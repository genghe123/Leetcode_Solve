// https://leetcode.com/problems/binary-tree-paths/description/

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTreeNode("1,2,3,null,5");
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        binaryTreePaths.binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<String> list = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        binaryTreePaths(root, list, builder);
        return list;
    }

    private void binaryTreePaths(TreeNode node, List<String> list, StringBuilder builder) {
        if (node == null) return;
        int lastPosition = builder.length();
        if (node.left == null && node.right == null) {
            builder.append(node.val);
            list.add(builder.toString());
            builder.delete(lastPosition, builder.length());
            return;
        }
        builder.append(node.val).append("->");
        binaryTreePaths(node.right, list, builder);
        binaryTreePaths(node.left, list, builder);
        builder.delete(lastPosition, builder.length());
    }
}
