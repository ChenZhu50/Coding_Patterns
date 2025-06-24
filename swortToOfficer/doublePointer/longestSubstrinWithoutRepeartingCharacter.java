package doublePointer;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class longestSubstrinWithoutRepeartingCharacter {
    
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j =0, maxLength =0;
        HashSet<Character> set = new HashSet<>();

        while(j< s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
                maxLength = Math.max(maxLength, j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";
        System.out.println("Test 1: " + lengthOfLongestSubstring(test1)); // Expected: 3
        System.out.println("Test 2: " + lengthOfLongestSubstring(test2)); // Expected: 1
        System.out.println("Test 3: " + lengthOfLongestSubstring(test3)); // Expected: 3
        System.out.println("Test 4: " + lengthOfLongestSubstring(test4)); // Expected: 0
    }
}
