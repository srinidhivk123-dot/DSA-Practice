/*
 Problem: Validate Binary Search Tree (LeetCode 98)
 Link: https://leetcode.com/problems/validate-binary-search-tree/
 Approach: Recursive DFS with a valid range (min, max) for every node.
           The root can be anything. Going left, the max becomes the parent's
           value. Going right, the min becomes the parent's value.
           A node outside its range means the tree is not a BST.
 Time: O(n), every node is visited once
 Space: O(h), recursion stack, h = height of the tree
*/

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}