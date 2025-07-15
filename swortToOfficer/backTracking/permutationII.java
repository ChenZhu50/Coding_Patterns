package backTracking;

import java.util.*;

public class permutationII {
    /**
     * LeetCode 47: Permutations II
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
     *
     * Example:
     * Input: nums = [1,1,2]
     * Output: [[1,1,2],[1,2,1],[2,1,1]]
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);

        backtrack(nums,track,used);
        return result;
    }

    private void backtrack(int [] nums, LinkedList<Integer> track, boolean [] used){
        if(track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }

        for(int i = 0; i < nums.length ; i++){
            if(used[i]){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.pop();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permutationII solver = new permutationII();
        List<List<Integer>> result = solver.permuteUnique(nums);
        System.out.println("All unique permutations: " + result);
    }
}
