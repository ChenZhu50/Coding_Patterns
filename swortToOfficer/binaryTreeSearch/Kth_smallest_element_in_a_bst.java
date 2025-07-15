package binaryTreeSearch;

import java.util.*;

public class Kth_smallest_element_in_a_bst {
    /**
     * LeetCode 230: Kth Smallest Element in a BST
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     */
    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return result;
    }
    private void traverse(TreeNode node, int k) {
        if(node == null) return;

        traverse(node.left, k);

        count++;
        if(k == count){
            result = node.val;
            return;
        }

        traverse(node.right, k);
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

    public static void main(String[] args) {
        // Test cases: {input tree as array, k, expected output}
        Object[][] testCases = {
            {new Integer[]{3,1,4,null,2}, 1, 1}, // kth = 1, output = 1
            {new Integer[]{5,3,6,2,4,null,null,1}, 3, 3}, // kth = 3, output = 3
            {new Integer[]{2,1,3}, 2, 2}, // kth = 2, output = 2
            {new Integer[]{1}, 1, 1}, // kth = 1, output = 1
        };

        for (int i = 0; i < testCases.length; i++) {
            Integer[] arr = (Integer[]) testCases[i][0];
            int k = (int) testCases[i][1];
            int expected = (int) testCases[i][2];
            TreeNode root = buildTree(arr);
            Kth_smallest_element_in_a_bst solver = new Kth_smallest_element_in_a_bst();
            int result = solver.kthSmallest(root, k);
            System.out.println("Test case " + (i+1) + ": Input = " + Arrays.toString(arr) + ", k = " + k);
            System.out.println("Output: " + result + ", Expected: " + expected + ", Pass: " + (result == expected));
            System.out.println();
        }
    }
}
