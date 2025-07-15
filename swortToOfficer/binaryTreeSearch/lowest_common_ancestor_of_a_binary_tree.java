package binaryTreeSearch;

import java.util.*;

import doublePointer.reverseWordInAString;

public class lowest_common_ancestor_of_a_binary_tree {
    /**
     * LeetCode 236: Lowest Common Ancestor of a Binary Tree
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * The definition of LCA is the lowest node that has both nodes as descendants (where a node can be a descendant of itself).
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        } 

        if(right == null){
            return left;
        }
        return root;
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

    // Helper method to find a node by value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        // Test cases: {input tree as array, p value, q value, expected LCA value}
        Object[][] testCases = {
            {new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, 5, 1, 3}, // LCA is 3
            {new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, 5, 4, 5}, // LCA is 5
            {new Integer[]{1,2}, 1, 2, 1},                        // LCA is 1
        };

        for (int i = 0; i < testCases.length; i++) {
            Integer[] arr = (Integer[]) testCases[i][0];
            int pVal = (int) testCases[i][1];
            int qVal = (int) testCases[i][2];
            int expectedVal = (int) testCases[i][3];
            TreeNode root = buildTree(arr);
            TreeNode p = findNode(root, pVal);
            TreeNode q = findNode(root, qVal);
            TreeNode result = lowestCommonAncestor(root, p, q);
            int resultVal = (result != null) ? result.val : -1;
            System.out.println("Test case " + (i+1) + ": Input = " + Arrays.toString(arr) + ", p = " + pVal + ", q = " + qVal);
            System.out.println("Output: " + resultVal + ", Expected: " + expectedVal + ", Pass: " + (resultVal == expectedVal));
            System.out.println();
        }
    }
}
