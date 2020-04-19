package Exercise;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public TreeNode<Key, Value> left, right;

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public static TreeNode constructTreeNode(String keys, String values) {
        // Construct a TreeNode through input
        String[] key = keys.split(",");
        String[] value = values.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(key[0], value[0]);
        queue.offer(root);

        for (int i = 1; i < key.length; ) {
            TreeNode node = queue.poll();
            if (node != null) {
                node.left = ("null".equals(key[i++])) ? null : new TreeNode(key[i - 1], value[i - 1]);
                node.right = (i < key.length && "null".equals(key[i++])) ? null : new TreeNode(key[i - 1], value[i - 1]);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public Iterable<TreeNode> nodes(IteratePattern pattern) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (pattern == IteratePattern.In) inIterate(this, queue);
        else if (pattern == IteratePattern.Post) postIterate(this, queue);
        else preIterate(this, queue);
        return queue;
    }

    private void preIterate(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        queue.add(node);
        preIterate(node.left, queue);
        preIterate(node.right, queue);
    }

    private void inIterate(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        inIterate(node.left, queue);
        queue.add(node);
        inIterate(node.right, queue);
    }

    private void postIterate(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        postIterate(node.left, queue);
        postIterate(node.right, queue);
        queue.add(node);
    }

    public boolean check() {
        return isBST(this, null, null);
    }

    private boolean isBST(TreeNode<Key, Value> node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    public int maxWidth() {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(this);
        int max = Integer.MIN_VALUE;
        while (true) {
            int length = queue.size();
            if (length == 0) break;

            while (length-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public void exchange() {
        exchange(this);
    }

    private void exchange(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        exchange(node.left);
        exchange(node.right);
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
            stringBuilder.append("<").append(node.key).append(",").append(node.value).append(">");
            if (!queue.isEmpty()) stringBuilder.append(',');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public enum IteratePattern {
        Pre,
        In,
        Post
    }
}
