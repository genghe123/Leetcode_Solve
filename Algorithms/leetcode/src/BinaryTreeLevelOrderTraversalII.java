// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    /*
    // DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderBottom(root, lists, 0);
        return lists;
    }

        private void levelOrderBottom(TreeNode node, List<List<Integer>> lists, int depth) {
        if (node == null) return;
        if (depth >= lists.size()) {
            lists.add(0, new LinkedList<Integer>());
        }
        levelOrderBottom(node.left, lists, depth + 1);
        levelOrderBottom(node.right, lists, depth + 1);
        lists.get(lists.size() - depth - 1).add(node.val);
    }
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int depth = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < depth; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            lists.add(0, subList);
        }
        return lists;
    }
}
