/*
 Problem: Binary Tree Maximum Path Sum (LeetCode 124)
 Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 Approach: Recursive DFS. For each node, find the best downward gain from its
           left and right child (ignore a side if its gain is negative).
           The best path that bends at this node = node + left gain + right gain,
           so update the global answer with it. Return only one side
           (node + the larger gain) to the parent, since a path can't branch upward.
 Time: O(n), every node is visited once
 Space: O(h), recursion stack, h = height of the tree
*/

public class MaxPathSum {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        gain(root);
        return max;
    }

    private int gain(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, gain(node.left));
        int right = Math.max(0, gain(node.right));

        max = Math.max(max, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}