package doublePointer;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        //TODO: Implement the logic to check if s is a subsequence of t
        //use two pointers to check if s is a subsequence of t
        int sIndex = 0;
        int tIndex = 0;

        while(sIndex < s.length() && tIndex < t.length()) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

        s = "";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

        s = "abc";
        t = "";
        System.out.println(isSubsequence(s, t));
        
    }
}