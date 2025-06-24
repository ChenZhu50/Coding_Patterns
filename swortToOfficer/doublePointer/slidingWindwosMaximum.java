package doublePointer;

public class slidingWindwosMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i =0, j =0, maxLength = 0;

        while(j < nums.length){
            j = i+k;
            
            Math.max(nums[i], nums[j]);

        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] test1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        int[] test2 = {1};
        int k2 = 1;
        int[] test3 = {9, 11};
        int k3 = 2;
        int[] test4 = {4, -2};
        int k4 = 2;
        System.out.println("Test 1: " + java.util.Arrays.toString(maxSlidingWindow(test1, k1))); // Expected: [3,3,5,5,6,7]
        System.out.println("Test 2: " + java.util.Arrays.toString(maxSlidingWindow(test2, k2))); // Expected: [1]
        System.out.println("Test 3: " + java.util.Arrays.toString(maxSlidingWindow(test3, k3))); // Expected: [11]
        System.out.println("Test 4: " + java.util.Arrays.toString(maxSlidingWindow(test4, k4))); // Expected: [4]
    }
}
