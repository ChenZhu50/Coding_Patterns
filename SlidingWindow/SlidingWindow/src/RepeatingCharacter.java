import java.util.*;
public class RepeatingCharacter {
    public static int longestRepeatingCharacterReplacement(String s, int k){
        //初始化变量
        //存储输入字符长度，长度
        int stringLength = s.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        //遍历输入数组
        for(int end =0; end < stringLength; ++end){
            char currentChar = s.charAt(end);

            //如果当前的char不在我们的map中，添加到map中，否则增加frequency
            //getOrdefault 让我们可以查看在不在，在的话+1 不在就0
            charFreq.put(currentChar,charFreq.getOrDefault(currentChar,0)+1);

            //更新most freq char
            mostFreqChar = Math.max(mostFreqChar,charFreq.get(currentChar));

            //如果超出了我们可以承受的最大替换量，我们就向后移动一个字符
            if (end - start + 1 - mostFreqChar > k) {
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start += 1;
            }

            //如果当前窗口是最长的窗口了，就update我们的lengthOfMaxSubstring
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end-start+1);

        }
        return lengthOfMaxSubstring;
    }
    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
