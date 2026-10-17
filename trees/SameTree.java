/*
 Problem: Same Tree (LeetCode 100)
 Link: https://leetcode.com/problems/same-tree/
 Approach: Recursive DFS, two nodes match if both are null, or both have
           the same value and their left and right subtrees also match
 Time: O(n), every node is visited once
 Space: O(h), recursion stack, h = height of the tree
*/

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}