package Search;

public class find_minimum_in_rotated_sorted_array_II {
    /**
     * LeetCode 154: Find Minimum in Rotated Sorted Array II
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * The array may contain duplicates.
     * Find the minimum element.
     * You may assume no duplicate exists in the array prior to rotation.
     */
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int current = 0;
        int next_number = 0;
        for(int i = 0; i < nums.length -1; i++){
            current = nums[i];
            next_number = nums[i + 1];

            if(current > next_number){
                return next_number;
            }
        } 
        return nums[0];
    }

    public static void main(String[] args) {
        // Test cases: {input, expected output}
        int[][] testInputs = {
            {1, 3, 5},            // Expected: 1
            {2, 2, 2, 0, 1},      // Expected: 0
            {10, 1, 10, 10, 10},  // Expected: 1
            {3, 3, 1, 3},         // Expected: 1
            {1, 1, 1, 1, 1},      // Expected: 1
        };
        int[] expected = {1, 0, 1, 1, 1};

        for (int i = 0; i < testInputs.length; i++) {
            int result = findMin(testInputs[i]);
            System.out.println("Test case " + (i+1) + ": Input = " + java.util.Arrays.toString(testInputs[i]));
            System.out.println("Output: " + result + ", Expected: " + expected[i] + ", Pass: " + (result == expected[i]));
            System.out.println();
        }
    }
}
