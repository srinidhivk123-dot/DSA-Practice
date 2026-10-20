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
    }
}