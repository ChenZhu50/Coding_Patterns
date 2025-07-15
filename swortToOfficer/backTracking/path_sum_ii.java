package backTracking;

import java.util.*;

public class path_sum_ii {
    /**
     * LeetCode 113: Path Sum II
     * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
     * Each path should be returned as a list of the node values, not node references.
     *
     * A root-to-leaf path is a path starting from the root and ending at any leaf node.
     *
     * Definition for a binary tree node:
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    List<List<Integer>> solution = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return solution;
        find_sum(root, targetSum);
        return solution;
    }
    
    private void find_sum(TreeNode root, int targetSum){
        if(root == null) return;
        path.add(root.val);
        targetSum -= root.val;

        if(targetSum == 0 && root.left == null && root.right == null){
            solution.add(new LinkedList<Integer>(path));
        }

        find_sum(root.left, targetSum);
        find_sum(root.right, targetSum);
        path.removeLast();
    }



    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        /*
         * Example tree:
         *      5
         *     / \
         *    4   8
         *   /   / \
         *  11  13  4
         * /  \    / \
         *7    2  5   1
         *
         * targetSum = 22
         * Expected output: [[5,4,11,2],[5,8,4,5]]
         */
        TreeNode root = new TreeNode(5,
            new TreeNode(4,
                new TreeNode(11,
                    new TreeNode(7),
                    new TreeNode(2)
                ),
                null
            ),
            new TreeNode(8,
                new TreeNode(13),
                new TreeNode(4,
                    new TreeNode(5),
                    new TreeNode(1)
                )
            )
        );
        int targetSum = 22;
        path_sum_ii solver = new path_sum_ii();
        List<List<Integer>> result = solver.pathSum(root, targetSum);
        System.out.println("Paths with sum " + targetSum + ": " + result);
    }
}
