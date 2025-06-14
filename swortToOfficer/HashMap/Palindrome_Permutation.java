public class Palindrome_Permutation {
    /**
     * Checks if a string can be rearranged to form a palindrome.
     * A string can form a palindrome if at most one character appears an odd number of times.
     * 
     * @param s The input string to check
     * @return true if the string can be rearranged to form a palindrome, false otherwise
     */
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26]; //创造一个26个字母的数组
        //统计每个字母出现的次数
        for (char c : s.toCharArray()) {
            //c - 'a' 将字母转换为0-25的数字
            count[c - 'a']++;
        }
        //创建一个计数器，统计出现奇数次的字母的个数
        int oddCount = 0;
        //遍历数组，统计出现奇数次的字母的个数
        for (int i : count) {
            if (i % 2 == 1) {
                oddCount++;
            }
        }
        //如果出现奇数次的字母的个数小于等于1，则可以重新排列成回文
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "tactcoa",    // Should return true (can form "tacocat")
            "code",       // Should return false
            "aab",        // Should return true (can form "aba")
            "carerac",    // Should return true (already a palindrome)
            "hello"       // Should return false
        };

        Palindrome_Permutation solution = new Palindrome_Permutation();
        
        for (String str : testStrings) {
            System.out.println("Input: \"" + str + "\"");
            boolean result = solution.canPermutePalindrome(str);
            System.out.println("Can form palindrome: " + result);
            System.out.println();
        }
    }
}
