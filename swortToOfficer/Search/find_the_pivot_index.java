package Search;

public class find_the_pivot_index {
    public static int pivotIndex(int[] nums) {
        //calc total sum
        int total_sum = 0;
        for(int num: nums){
            total_sum += num;
        }

        int left_sum = 0;

        // literate the whole array
        for(int i = 0; i < nums.length; i++){
            //calc what's the sum for right
            int right_sum = total_sum - left_sum - nums[i];

            if(right_sum == left_sum){
                return i;
            }

            //add to left and go over the for loop again.
            left_sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases: {input, expected output}
        int[][] testInputs = {
            {1, 7, 3, 6, 5, 6},   // Expected: 3
            {1, 2, 3},            // Expected: -1
            {2, 1, -1},           // Expected: 0
            {0, 0, 0, 0, 1},      // Expected: 4
            {1, -1, 0},           // Expected: 2
        };
        int[] expected = {3,-1,0,4, 2};

        for (int i = 0; i < testInputs.length; i++) {
            int result = pivotIndex(testInputs[i]);
            System.out.println("Test case " + (i+1) + ": Input = " + java.util.Arrays.toString(testInputs[i]));
            System.out.println("Output: " + result + ", Expected: " + expected[i] + ", Pass: " + (result == expected[i]));
            System.out.println();
        }
    }
}
