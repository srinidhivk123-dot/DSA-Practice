import java.util.*;

/*
 Problem: Serialize and Deserialize Binary Tree (LeetCode 297)
 Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 Approach: Preorder traversal, writing N for every null node. Deserialize
           reads the values back in the same order using a shared queue.
 Time: O(n), every node is visited once
 Space: O(n), string plus queue plus recursion stack
*/

public class SerializeDeserializeTree {
    public String serialize(TreeNode root) {
        if (root == null) return "N,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }

    private TreeNode build(Queue<String> q) {
        String s = q.poll();
        if (s.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = build(q);
        node.right = build(q);
        return node;
    }
}