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
    }
}