package SlidingWindow.Q1_Longest_Substring_without_repreating_characters;

import java.util.*;

public class Main {
    public static int findLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int startOfWindow = 0;
        int maxLength = 0;

        for(int i = 0; i<str.length(); i++) {
            char rightChar = str.charAt(i);
            if(map.containsKey(rightChar)) {
                startOfWindow = Math.max(startOfWindow, map.get(rightChar) + 1);
            }
            map.put(rightChar, i);
            maxLength = Math.max(maxLength, i - startOfWindow + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "abcabcbb"; // Expected output: 3 ("abc")
        String test2 = "bbbbb";    // Expected output: 1 ("b")
        String test3 = "pwwkew";   // Expected output: 3 ("wke")
        String test4 = "";         // Expected output: 0 (empty string)
        String test5 = "abcdef";   // Expected output: 6 ("abcdef")
        
        System.out.println("Test 1: " + findLongestSubstring(test1)); // Expected: 3
        System.out.println("Test 2: " + findLongestSubstring(test2)); // Expected: 1
        System.out.println("Test 3: " + findLongestSubstring(test3)); // Expected: 3
        System.out.println("Test 4: " + findLongestSubstring(test4)); // Expected: 0
        System.out.println("Test 5: " + findLongestSubstring(test5)); // Expected: 6
    }
}

