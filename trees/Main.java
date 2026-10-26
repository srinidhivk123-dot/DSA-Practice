public class Main {
    public static void main(String[] args) {

        TreeNode root = TreeNode.build(4, 2, 7, 1, 3, 6, 9);

        System.out.print("Original: ");
        TreeNode.print(root);

       // Invert Binary Tree
        TreeNode inverted = new InvertBinaryTree().invertTree(root);
        System.out.print("Inverted: ");
        TreeNode.print(inverted);     
        
        // Same Tree
        TreeNode a = TreeNode.build(1, 2, 3);
        TreeNode b = TreeNode.build(1, 2, 3);
        TreeNode c = TreeNode.build(1, 2, 4);
        System.out.println("Same (a, b): " + new SameTree().isSameTree(a, b)); // true
        System.out.println("Same (a, c): " + new SameTree().isSameTree(a, c)); // false

        // Subtree of Another Tree
        TreeNode big1 = TreeNode.build(3, 4, 5, 1, 2);
        TreeNode big2 = TreeNode.build(3, 4, 5, 1, 2, null, null, 0);
        TreeNode small = TreeNode.build(4, 1, 2);
        System.out.println("Subtree (big1): " + new SubtreeOfAnotherTree().isSubtree(big1, small)); // true
        System.out.println("Subtree (big2): " + new SubtreeOfAnotherTree().isSubtree(big2, small)); // false

        // Level Order Traversal
        TreeNode lo = TreeNode.build(3, 9, 20, null, null, 15, 7);
        System.out.println("Level order: " + new LevelOrderTraversal().levelOrder(lo));

        // Serialize and Deserialize
        TreeNode sd = TreeNode.build(1, 2, 3, null, null, 4, 5);
        SerializeDeserializeTree codec = new SerializeDeserializeTree();
        String s = codec.serialize(sd);
        System.out.println("Serialized: " + s);
        System.out.print("Deserialized: ");
        TreeNode.print(codec.deserialize(s));

        // Maximum Depth
        TreeNode md = TreeNode.build(3, 9, 20, null, null, 15, 7);
        System.out.println("Max depth: " + new MaxDepth().maxDepth(md));

        // Maximum Path Sum
        TreeNode ps1 = TreeNode.build(1, 2, 3);
        TreeNode ps2 = TreeNode.build(-10, 9, 20, null, null, 15, 7);
        TreeNode ps3 = TreeNode.build(-3);
        System.out.println("Max path sum (ps1): " + new MaxPathSum().maxPathSum(ps1));
        System.out.println("Max path sum (ps2): " + new MaxPathSum().maxPathSum(ps2));
        System.out.println("Max path sum (ps3): " + new MaxPathSum().maxPathSum(ps3));

        // Validate BST
        TreeNode v1 = TreeNode.build(2, 1, 3);
        TreeNode v2 = TreeNode.build(5, 1, 4, null, null, 3, 6);
        TreeNode v3 = TreeNode.build(2147483647);
        System.out.println("Valid BST (v1): " + new ValidateBST().isValidBST(v1));
        System.out.println("Valid BST (v2): " + new ValidateBST().isValidBST(v2));
        System.out.println("Valid BST (v3): " + new ValidateBST().isValidBST(v3));

        // Kth Smallest in BST
        TreeNode k1 = TreeNode.build(3, 1, 4, null, 2);
        TreeNode k2 = TreeNode.build(5, 3, 6, 2, 4, null, null, 1);
        System.out.println("Kth smallest (k1, k=1): " + new KthSmallestBST().kthSmallest(k1, 1));
        System.out.println("Kth smallest (k2, k=3): " + new KthSmallestBST().kthSmallest(k2, 3));

        static TreeNode find(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            root = val < root.val ? root.left : root.right;
        }
        return null;
        }
        // Lowest Common Ancestor of BST
        TreeNode lc = TreeNode.build(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        LowestCommonAncestorBST lca = new LowestCommonAncestorBST();
        System.out.println("LCA of 2 and 8: " + lca.lowestCommonAncestor(lc, find(lc, 2), find(lc, 8)).val);
        System.out.println("LCA of 2 and 4: " + lca.lowestCommonAncestor(lc, find(lc, 2), find(lc, 4)).val);
        System.out.println("LCA of 3 and 5: " + lca.lowestCommonAncestor(lc, find(lc, 3), find(lc, 5)).val);

        public class Main {

    static TreeNode find(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        // all your tests here, including the LCA lines
    }
}
    }
}