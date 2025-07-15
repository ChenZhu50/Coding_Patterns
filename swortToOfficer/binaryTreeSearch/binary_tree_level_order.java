package binaryTreeSearch;

import java.util.*;

public class binary_tree_level_order {
    /**
     * LeetCode 102: Binary Tree Level Order Traversal
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null){
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for(int i=1; i<=currentLevelSize;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Helper method to build a tree from an array (null for missing nodes)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Helper method to compare two List<List<Integer>>
    public static boolean compareLevelOrder(List<List<Integer>> a, List<List<Integer>> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases: {input tree as array, expected output}
        Integer[][] testInputs = {
            {3,9,20,null,null,15,7}, // [[3],[9,20],[15,7]]
            {1},                    // [[1]]
            {},                     // []
            {1,2,3,4,null,null,5},  // [[1],[2,3],[4,5]]
        };
        List<List<List<Integer>>> expected = Arrays.asList(
            Arrays.asList(Arrays.asList(3), Arrays.asList(9,20), Arrays.asList(15,7)),
            Arrays.asList(Arrays.asList(1)),
            new ArrayList<>(),
            Arrays.asList(Arrays.asList(1), Arrays.asList(2,3), Arrays.asList(4,5))
        );

        for (int i = 0; i < testInputs.length; i++) {
            TreeNode root = buildTree(testInputs[i]);
            List<List<Integer>> result = levelOrder(root);
            System.out.println("Test case " + (i+1) + ": Input = " + Arrays.toString(testInputs[i]));
            System.out.println("Output: " + result + ", Expected: " + expected.get(i) + ", Pass: " + compareLevelOrder(result, expected.get(i)));
            System.out.println();
        }
    }
}
