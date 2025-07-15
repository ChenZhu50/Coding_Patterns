package Simulation;
import java.util.*;

public class validStackSequence {
    
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;
        int j = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while(stack.size() != 0 && popped[j] == stack.peek()){
                stack.pop();
                j++;
                if(j == popped.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] pushed1 = {1,2,3,4,5}, popped1 = {4,5,3,2,1};
        // int[] pushed2 = {1,2,3,4,5}, popped2 = {4,3,5,1,2};
        int[] pushed3 = {1,0}, popped3 = {1,0};
        // int[] pushed4 ={0}, popped4 = {0};
        // System.out.println("Test 1: " + validateStackSequences(pushed1, popped1)); // Expected: true
        // System.out.println("Test 2: " + validateStackSequences(pushed2, popped2)); // Expected: false
        System.out.println("Test 3: " + validateStackSequences(pushed3, popped3)); // Expected: true
        //System.out.println("Test 4: " + validateStackSequences(pushed4, popped4)); // Expected: true
    }
}
