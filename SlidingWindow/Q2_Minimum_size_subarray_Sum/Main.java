package SlidingWindow.Q2_Minimum_size_subarray_Sum;

import java.util.Arrays;

class MinimumSubArraySum{
    public static int minSubArrayLen(int target, int[] nums) {
       int min_Window_size = Integer.MAX_VALUE; 
       for(int i =0; i<nums.length; i++){
            

            }
          
       return -1;
    }
 }

public class Main {
     public static void main(String[] args) {
        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
            {2, 3, 1, 2, 4, 3},
            {1, 4, 4},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4},
            {1, 2, 1, 3},
            {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
