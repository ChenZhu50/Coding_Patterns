package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class threeSum {
    
    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        // TODO: Implement your solution here
        Arrays.sort(nums); //sort the array, so that we could use the the save logic tahts ow two sum to slove this one

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i =0; i < n-2; i++){
            //since we already sorted, so those numbers that close togethere will be the same, if there are dupilcaition.
            //Thus, we only need to compare with it's neignber.
            if(i >0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {-1,0,1,2,-1,-4};
        int[] test2 = {0,1,1};
        int[] test3 = {0,0,0};
        System.out.println("Test 1: " + threeSum(test1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println("Test 2: " + threeSum(test2)); // Expected: []
        System.out.println("Test 3: " + threeSum(test3)); // Expected: [[0, 0, 0]]
    }
}
