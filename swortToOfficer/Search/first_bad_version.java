package Search;
import java.util.*;

public class first_bad_version {
    // Simulate the isBadVersion API (for testing)
    private static int badVersion = 0;
    public static boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        if(right == 1) return 1;
        int mid = 0;

        while(left < right){
            mid = (right-left)/2 + left;
            if(isBadVersion(mid)){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int n1 = 5;
        badVersion = 4;
        int expected1 = 4;
        int result1 = firstBadVersion(n1);

        int n2 = 1;
        badVersion = 1;
        int expected2 = 1;
        int result2 = firstBadVersion(n2);

        int n3 = 7;
        badVersion = 6;
        int expected3 = 6;
        int result3 = firstBadVersion(n3);

        System.out.println("Test 1: " + result1 + " | Correct? " + (result1 == expected1));
        System.out.println("Test 2: " + result2 + " | Correct? " + (result2 == expected2));
        System.out.println("Test 3: " + result3 + " | Correct? " + (result3 == expected3));
    }
}
