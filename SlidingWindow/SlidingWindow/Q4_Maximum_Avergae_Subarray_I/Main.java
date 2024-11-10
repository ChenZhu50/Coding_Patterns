package SlidingWindow.Q4_Maximum_Avergae_Subarray_I;

public class Main {
    public static void main(String[] args) {
        int[][] inputData = {
                { 3, -2, 5, -1, 6, 8 }
                // {10, 5, 2, -1, 6, 3, -2, -4, 4, 1, -3, -6, -1, -2, -5, -7},
                // {7, 3, 1, -2, 6, 2, -1, -3, 4, 1, -2, -5, 2, 0, -4, -6},
                // {12, 9, 5, 2, 8, 6, 4, 1, 7, 5, 3, 0, 4, 2, 0, -3},
                // {-10, -11, -12, -13, -20, -21, -22, -23, -30, -31, -32, -33, -40, -41, -42,
                // -43},
                // {5, 3, -2, -3, 4, 2, -3, -4, 3, 1, -4, -5, 2, 0, -5, -6}
        };

        int k = 4;

        for (int i = 0; i < inputData.length; i++) {
            int[] nums = inputData[i];
            double result = findMaxAverage(nums, k);
            System.out.print("Array: {");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("}, k = " + k);
            System.out.printf("\tMaximum Average: %.2f%n", result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static double findMaxAverage(int[] nums, int k) {
        /*
         * 1. 初始化一个最大sun（等于math中的最小），初始化一个current_sum 保存当前窗口内数据的大小
         * 2. 移动我们的窗口，让其前进
         * 3. 更新最大sum，如果更大
         */

        // 初始化：
        // 让max_sum等于负无穷
        double max_sum = Double.NEGATIVE_INFINITY;
        int window_size = k;
        double current_mean = 0.0;
        double current_sum = 0.0;

        for (int i = 0; i < window_size; i++) {
            current_sum += nums[i];
        }
        if (window_size == nums.length)
            return (current_sum / window_size);

        for (int i = 0; nums.length-1 >= i + window_size; i++) {
            current_sum = current_sum - nums[i];
            current_sum = current_sum + nums[i + window_size];
            current_mean = current_sum / window_size;
            max_sum = Math.max(current_mean, max_sum);
        }
        return max_sum;
    }
}
