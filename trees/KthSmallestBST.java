/*
 Problem: Kth Smallest Element in a BST (LeetCode 230)
 Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 Approach: Inorder traversal of a BST visits values in sorted order.
           Count nodes as they are visited and stop at the kth one.
 Time: O(h + k), stops early once the kth node is found
 Space: O(h), recursion stack, h = height of the tree
*/

public class KthSmallestBST {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}