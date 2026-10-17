/*
 Problem: Invert Binary Tree (LeetCode 226)
 Link: https://leetcode.com/problems/invert-binary-tree/
 Approach: Recursive DFS, swap the left and right child at every node
 Time: O(n), every node is visited once
 Space: O(h), recursion stack, h = height of the tree
*/

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}