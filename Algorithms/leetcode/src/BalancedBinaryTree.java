// https://leetcode.com/problems/balanced-binary-tree/description/
// Algorithms 4th Edition Ex.3.2.25 Perfect Balance 完美平衡
public class BalancedBinaryTree {
    /*
    //Definition of Balanced Binary Tree : no 2 leaf nodes differ in distance from the root by more than 1

    public boolean isBalanced(TreeNode root) {
        int[] status = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        isBalanced(root, status, 0);
        return status[1] - status[0] <= 1;
    }

    private boolean isBalanced(TreeNode node, int[] status, int current) {
        if (node == null) return true;
        if (node.left == null || node.right == null) {
            status[0] = Math.min(status[0], current);
            status[1] = Math.max(status[1], current);
        }
        return isBalanced(node.left, status, current + 1)
                && isBalanced(node.right, status, current + 1);
    }
    */

    // Definition of Balanced Binary Tree : two subtrees of every node never differ by more than 1

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
