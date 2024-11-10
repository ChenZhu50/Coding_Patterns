public class minimumWindowSubsequence {
    public static String minWindow(String str1, String str2) {
        //初始化参数：

        // 输入字符大小：str1 and str2
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();

        // 初始化最小subsequent长度：minSubLen （设置为无限大，确保任何找到的都比初始值小）
        float minSubLen = Float.POSITIVE_INFINITY;

        // 初始化指向两个字符头的指针：
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;

        //初始化最小subsequence字符串为空（只要找到就可以写入）
        String minSubsequence = "";

        //只要我们的str1还没有遍历结束就继续遍历
        while(indexS1 < sizeStr1){

            //如果满足条件1，也就是str1和str2在当前位置相等
            if(str1.charAt(indexS1) == str2.charAt(indexS2)){

                //只要是当前位置相等，就需要让str2的指针+1
                indexS2 += 1;

                //如果当前已经到了str2的末尾了，就说明我们找完了
                if (indexS2 == sizeStr2) {
                    //此时我们将指针都指向这个subsequence的末尾
                    start = indexS1;
                    end = indexS1;

                    //因为最后一个字符一定是相等的，所以我们就让indexS2 - 1
                    //用来找前一个字符
                    indexS2 -= 1;

                    //只要还没找到str2的头，就继续找
                    while (indexS2 >= 0) {
                        //注意此时start作为指针来遍历当前窗口
                        if (str1.charAt(start) == str2.charAt(indexS2)) {
                            indexS2 -= 1;
                        }

                        //保持尾部指针不要动，只移动头部指针来遍历我们当前的Subsequence
                        start -= 1;
                    }

                    //出了这个循环，则表示我们找到了一个新的头，
                    //这个头包含着当前subsequence中最短的subsequence
                    start += 1;

                    //如果我们找到的值小于minSubLen的长度（第一次只要找到必定短于）
                    //就更新minSubLen和SubSequence
                    if ((end - start + 1) < minSubLen){
                        minSubLen = end- start+1;
                        minSubsequence = str1.substring(start,end+1);
                    }

                    //让str1的指针指向当前这个最小window的最后一位
                    //要查看后面是否有更短的
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            //当然如果以上情况都不满足，我们则需要让indexS1+1 来进行下一次循环
            indexS1 += 1;
        }
        return minSubsequence;
    }
    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
                "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "adeq", "kzed", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
