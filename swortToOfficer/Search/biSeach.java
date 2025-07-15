package Search;
import java.util.*;

public class biSeach {
    public static int search(int[] nums, int target) {
        
        return binary_search(nums,target,0, nums.length-1);
    }
    private static int binary_search(int [] nums, int target, int left, int right){
        if(left > right) return -1;

        int mid = (left+right)/2;

        if(nums[mid] == target){
            return mid;
        }

        else if(nums[mid] < target){
            return binary_search(nums, target, mid+1, right);
        }

        else{
            return binary_search(nums, target, left, mid-1);
        }
    }

    public static void main(String[] args) {
        int[] test1 = {-1,0,3,5,9,12};
        int target1 = 9;
        int expected1 = 4;
        int[] test2 = {-1,0,3,5,9,12};
        int target2 = 2;
        int expected2 = -1;
        int[] test3 = {1};
        int target3 = 1;
        int expected3 = 0;

        int result1 = search(test1, target1);
        int result2 = search(test2, target2);
        int result3 = search(test3, target3);
        System.out.println("Test 1: " + result1 + " | Correct? " + (result1 == expected1));
        System.out.println("Test 2: " + result2 + " | Correct? " + (result2 == expected2));
        System.out.println("Test 3: " + result3 + " | Correct? " + (result3 == expected3));
    }
}
