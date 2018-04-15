// https://leetcode.com/problems/balanced-binary-tree/description/
// Algorithms 4th Edition Ex.3.2.25 Perfect Balance 完美平衡

//todo unhandled exception: [3,1,null,null,2]: chain tree
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 0);
    }

    private boolean isBalanced(TreeNode node, int[] status, int current) {
        if (node != null && node.left != null && node.right != null) {
            return isBalanced(node.left, status, current + 1)
                    && isBalanced(node.right, status, current + 1);
        }
        status[0] = Math.min(status[0], current);
        status[1] = Math.max(status[1], current);
        return status[1] - status[0] > 1;
    }
}
