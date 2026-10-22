/*
 Problem: Lowest Common Ancestor of a Binary Search Tree (LeetCode 235)
 Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 Approach: Use the BST property. If both p and q are smaller than the current
           node, the answer is in the left subtree. If both are larger, it is in
           the right subtree. Otherwise the current node splits them (or equals
           one of them), so it is the lowest common ancestor.
 Time: O(h), one path from the root down
 Space: O(1), iterative, no recursion stack
*/

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}