import java.util.*;
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        //检查validation：
        if(t.isEmpty()) return "";

        // initalization
        int l = 0;
        int r = 0;
        Map<Character,Integer> reqCount = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int[] res = {-1,-1};
        int required = 0;
        int current = 0;
        int resLen = Integer.MAX_VALUE;

        // 主代码结构（具体初始化）
        //首先先让左右都在S的初始位置
            //目前俩人都是0就是在了

        //将t的frequency 装入 reqCount中
        for(int i = 0; i < t.length(); i++){
            char currentChar = t.charAt(i);
            reqCount.put(currentChar,reqCount.getOrDefault(currentChar,0)+1);
        }

//        //打印查看reqCount中的内容，频率是否正确
//        System.out.println("reqCount: " + reqCount);

        // //将t的长度设置为required count，

        // //required = t.length();// 可以，但是会很麻烦，
        // 我们让required的长度只等于绝对的字符数量，比如ABBA 那么 required = 2
        //让Count的增长方式变为比较reqCount和window map中的值是否相等
        required = reqCount.size();

        //更新window的map，但初始化为0
        reqCount.forEach((key,value) -> window.put(key,0));

//        //查看window是否成功设置
//        System.out.println("Initial window: " + window);



        //滑动窗口部分：
        for(r = 0; r < s.length();r++){
            char currentChar = s.charAt(r);

            //如果当前char 在t中也存在，则将其增加到window中
            if(t.indexOf(currentChar) != -1){
                window.put(currentChar, 1+window.getOrDefault(currentChar,0));
            }

            //之前提到过的current的唯一增长方式
            if(reqCount.containsKey(currentChar) && window.get(currentChar).equals(reqCount.get(currentChar))){
                current += 1;
            }


            //开始缩短窗口大小，从头缩
            while(current == required){
                //结果更新，如果所有条件都还成立的条件下，我的总长度比上一次最短要短就更新
                if((r - l +1) < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = (r - l+1);
                }

                //保存以下我最左边的char，因为要拿其对比当前我们查看的是不是在t里面
                char leftChar = s.charAt(l);

                //如果我能在t中找到了，那么就要让windows中的值-1
                if(t.indexOf(leftChar) != -1){
                    window.put(leftChar,window.get(leftChar)-1);
                }

                if (reqCount.containsKey(leftChar) && window.get(leftChar) < reqCount.get(leftChar)){
                    current -= 1;
                }
                l += 1;
            }
        }
        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex,rightIndex+1): "";
    }
    public static void main(String[] args) {
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD"};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\ts: " + s[i] + "\n\tt: " + t[i] + "\n\tThe minimum substring containing " + t[i] + " is: " + minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

