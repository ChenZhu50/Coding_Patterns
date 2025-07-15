package backTracking;

import java.util.*;

public class Combination_sum {
    /**
     * LeetCode 39: Combination Sum
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * The same number may be chosen from candidates an unlimited number of times.
     *
     * Example:
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track  = new LinkedList<>();
        backTrack(candidates, 0, track, target);
        return result;
    }

    private void backTrack(int[] candidates, int startIndex, LinkedList<Integer>track, int target){
        if(target == 0){
            result.add(new ArrayList<>(track));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++ ){
            if (target - candidates[i] < 0) continue; // 剪枝
            target -= candidates[i];
            track.add(candidates[i]);
            backTrack(candidates, i, track, target);
            target += candidates[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Combination_sum solver = new Combination_sum();
        List<List<Integer>> result = solver.combinationSum(candidates, target);
        System.out.println("All combinations that sum to " + target + ": " + result);
    }
}
