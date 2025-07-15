package backTracking;

import java.util.*;

public class permutations {
    /**
     * LeetCode 46: Permutations
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     *
     * Example:
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void swap(int a, int b){
        int temp = path.get(a);
        path.set(a, path.get(b));
        path.set(b,temp); 
    }

    public List<List<Integer>> permute(int[] nums) {
        for(int num: nums){
            path.add(num);
        }
        backtrack(0);
        return result;
    }

    private void backtrack(int x){
        if(x == path.size() - 1){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = x;  i < path.size(); i++){
            swap(i,x);
            backtrack(x + 1);
            swap(x, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permutations solver = new permutations();
        List<List<Integer>> result = solver.permute(nums);
        System.out.println("All permutations: " + result);
    }
}
