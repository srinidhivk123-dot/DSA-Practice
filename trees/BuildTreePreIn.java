import java.util.*;

/*
 Problem: Construct Binary Tree from Preorder and Inorder Traversal (LeetCode 105)
 Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 Approach: The first element of preorder is always the root. Find that root in
           inorder: everything to its left is the left subtree, everything to
           its right is the right subtree. A HashMap gives the root's position
           in O(1), and a moving preIndex picks the next root in preorder.
 Time: O(n), every node is created once
 Space: O(n), HashMap plus recursion stack
*/

public class BuildTreePreIn {
    private int preIndex;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inMap.get(rootVal);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}