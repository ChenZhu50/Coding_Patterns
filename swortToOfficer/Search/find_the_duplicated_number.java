package Search;

public class find_the_duplicated_number {
    public static int findDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return -1;

        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        // Test cases: {input, expected output}
        int[][] testInputs = {
            {1, 3, 4, 2, 2},      // Expected: 2
            {3, 1, 3, 4, 2},      // Expected: 3
            {1, 1},               // Expected: 1
            {1, 4, 4, 2, 4},      // Expected: 4
            {2, 2, 2, 2, 2},      // Expected: 2
            {1, 4, 6, 2, 5, 3, 6},// Expected: 6
            {5, 1, 2, 3, 4, 6, 7, 8, 9, 5}, // Expected: 5
            {3, 3, 3, 3, 3, 3, 3},          // Expected: 3
            {4, 3, 1, 4, 2, 4}              // Expected: 4
        };
        
        int[] expected = {2, 3, 1, 4, 2, 6, 5, 3, 4};
        

        for (int i = 0; i < testInputs.length; i++) {
            int result = findDuplicate(testInputs[i]);
            System.out.println("Test case " + (i+1) + ": Input = " + java.util.Arrays.toString(testInputs[i]));
            System.out.println("Output: " + result + ", Expected: " + expected[i] + ", Pass: " + (result == expected[i]));
            System.out.println();
        }
    }
}
