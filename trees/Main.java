public class Main {
    public static void main(String[] args) {

        TreeNode root = TreeNode.build(4, 2, 7, 1, 3, 6, 9);

        System.out.print("Original: ");
        TreeNode.print(root);

       // Invert Binary Tree
        TreeNode inverted = new InvertBinaryTree().invertTree(root);
        System.out.print("Inverted: ");
        TreeNode.print(inverted);     
        
    }
}