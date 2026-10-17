import java.util.*;

public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Build a tree from LeetCode-style input (null = no node)
    // Example: TreeNode.build(4, 2, 7, 1, 3, 6, 9)
    static TreeNode build(Integer... vals) {
        if (vals.length == 0 || vals[0] == null) return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            TreeNode cur = q.poll();
            if (i < vals.length && vals[i] != null) {
                cur.left = new TreeNode(vals[i]);
                q.add(cur.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                cur.right = new TreeNode(vals[i]);
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    // Print the tree level by level, to check results
    static void print(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        List<String> out = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                out.add("null");
                continue;
            }
            out.add(String.valueOf(cur.val));
            q.add(cur.left);
            q.add(cur.right);
        }
        // remove trailing nulls
        int end = out.size();
        while (end > 0 && out.get(end - 1).equals("null")) end--;
        System.out.println(out.subList(0, end));
    }
}