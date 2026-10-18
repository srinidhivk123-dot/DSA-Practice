/*
 Problem: Subtree of Another Tree (LeetCode 572)
 Link: https://leetcode.com/problems/subtree-of-another-tree/
 Approach: At every node of root, check if the tree starting there is the
           same as subRoot (same logic as Same Tree). If not, try the
           left and right children.
 Time: O(m * n), m = nodes in root, n = nodes in subRoot
 Space: O(h), recursion stack, h = height of root
*/

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}