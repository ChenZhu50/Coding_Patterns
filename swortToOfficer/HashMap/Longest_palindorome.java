public class Longest_palindorome {
    /**
     * Finds the length of the longest palindrome that can be built from the given string.
     * Characters can be rearranged to form the palindrome.
     * 
     * @param s The input string
     * @return The length of the longest possible palindrome
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128]; 

        for(char c : s.toCharArray()){
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;
        for(int i : count){
            if(i % 2 == 0){
                length += i;
            }else{
                length += i - 1;
                hasOdd = true;
            }
        }
        return length + (hasOdd ? 1 : 0);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "abccccdd",  // Should return 7 (can form "dccaccd")
            "a",         // Should return 1
            "bb",        // Should return 2
            "ccc",       // Should return 3
            "ab",        // Should return 1
            "aaaa"       // Should return 4
        };

        Longest_palindorome solution = new Longest_palindorome();
        
        for (String str : testStrings) {
            System.out.println("Input: \"" + str + "\"");
            int result = solution.longestPalindrome(str);
            System.out.println("Length of longest possible palindrome: " + result);
            System.out.println();
        }
    }
}
