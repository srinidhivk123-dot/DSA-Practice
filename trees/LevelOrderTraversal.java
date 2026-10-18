import java.util.*;

/*
 Problem: Binary Tree Level Order Traversal (LeetCode 102)
 Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 Approach: BFS with a queue. For each level, take the current queue size,
           process exactly that many nodes, and add their children.
 Time: O(n), every node is visited once
 Space: O(n), queue holds up to one full level of nodes
*/

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
        }

        return result;
    }
}