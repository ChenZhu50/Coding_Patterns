package doublePointer;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.beans.binding.IntegerExpression;

public class slidingWindwosMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //checking if array have elements inside
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] res = new int[n-k+1]; // how many slide windows we could have
        Deque<Integer> deque = new ArrayDeque<>(); // store index

        for(int i =0; i < n; i++){
            //remove the index that not include in current slide windows
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }

            //compare the current value, 
            //if current value is bigger then the last value in the deque, we pop the element from the end
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){ //? so you know that, when we store, we store the index, not the value
                //? then how? when you compare, you only use peek will give the the value, not the index?
                deque.pollLast();
            }

            //at here, the current value should be the largerst in the queue.
            deque.offerLast(i);

            //adding the value in the res array
            if(i>= k-1){ //?why k-1?
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
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
