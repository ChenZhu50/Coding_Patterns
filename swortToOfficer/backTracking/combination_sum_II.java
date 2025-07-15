package backTracking;

import java.util.*;

public class combination_sum_II {
    /**
     * LeetCode 40: Combination Sum II
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     *
     * Example:
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean [] used = new boolean[candidates.length];
        Arrays.sort(candidates); 
        backTracking(candidates, 0, track, target, used);
        return result;
    }

    private void backTracking(int[] candidates, int startIndex, LinkedList<Integer>track, int target, boolean [] used){
        if(target == 0){
            result.add(new ArrayList<>(track));
            return;
        }

        if(startIndex >= candidates.length){
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(target - candidates[i] < 0) continue;
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            target -= candidates[i];
            track.add(candidates[i]);
            used[i] = true;
            backTracking(candidates, i+1, track, target,used);
            target += candidates[i];
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combination_sum_II solver = new combination_sum_II();
        List<List<Integer>> result = solver.combinationSum2(candidates, target);
        System.out.println("All unique combinations that sum to " + target + ": " + result);
    }
}
