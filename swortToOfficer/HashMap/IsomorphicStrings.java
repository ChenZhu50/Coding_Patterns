import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            //check if the mapping is consistent
            if(sToT.containsKey(sChar) && sToT.get(sChar) != tChar) {
                return false;
            }

            if(tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }

            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases for Leetcode 205
        String[][] testCases = {
            {"egg", "add"},
            {"foo", "bar"},
            {"paper", "title"},
            {"ab", "aa"},
            {"", ""},
            {"a", "a"},
            {"abc", "def"},
            {"aba", "baa"}
        };
        for (String[] testCase : testCases) {
            String s = testCase[0];
            String t = testCase[1];
            System.out.printf("isIsomorphic(\"%s\", \"%s\") = %b\n", s, t, isIsomorphic(s, t));
        }
    }
}

