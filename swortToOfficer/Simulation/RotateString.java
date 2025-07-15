package Simulation;

public class RotateString {
    
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        for(int i = 0; i < s.length(); i++){
            s = s.substring(1) +s.charAt(0);
            if(s.equals(goal)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcde", goal1 = "cdeab";
        String s2 = "abcde", goal2 = "abced";
        String s3 = "a", goal3 = "a";
        System.out.println("Test 1: " + rotateString(s1, goal1)); // Expected: true
        System.out.println("Test 2: " + rotateString(s2, goal2)); // Expected: false
        System.out.println("Test 3: " + rotateString(s3, goal3)); // Expected: true
    }
}
