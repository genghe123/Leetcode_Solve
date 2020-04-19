import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode constructTreeNode(String args) {
        // Construct a TreeNode through input
        String[] nums = args.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        queue.offer(root);

        for (int i = 1; i < nums.length; ) {
            TreeNode node = queue.poll();
            if (node != null) {
                node.left = ("null".equals(nums[i++])) ? null : new TreeNode(Integer.parseInt(nums[i - 1]));
                node.right = (i < nums.length && "null".equals(nums[i++])) ? null : new TreeNode(Integer.parseInt(nums[i - 1]));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        //return super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            stringBuilder.append(node.val);
            if (!queue.isEmpty()) stringBuilder.append(',');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
