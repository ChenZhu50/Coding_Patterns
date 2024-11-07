package SlidingWindow.Q2_Minimum_size_subarray_Sum;

import java.util.Arrays;

class MinimumSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int windowSize = Integer.MAX_VALUE;
        int currSubArrSize = 0;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                currSubArrSize = end - start + 1;
                windowSize = Math.min(windowSize, currSubArrSize);
                sum -= nums[start];
                start++;
            }
        }
        if (windowSize != Integer.MAX_VALUE) {
            return windowSize;
        } else {
            return 0;

        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] target = { 7, 4, 11, 10, 5, 15 };
        int[][] inputArr = {
                { 2, 3, 1, 2, 4, 3 },
                { 1, 4, 4 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 3, 4 },
                { 1, 2, 1, 3 },
                { 5, 4, 9, 8, 11, 3, 7, 12, 15, 44 }
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = MinimumSubArraySum.minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
