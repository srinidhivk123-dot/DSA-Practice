/*
 Problem: Maximum Depth of Binary Tree (LeetCode 104)
 Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 Approach: Recursive DFS, depth of a node = 1 + max(depth of left, depth of right).
           A null node has depth 0.
 Time: O(n), every node is visited once
 Space: O(h), recursion stack, h = height of the tree
*/

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}