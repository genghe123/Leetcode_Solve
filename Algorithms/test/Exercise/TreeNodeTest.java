package Exercise;

import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {

    public TreeNode createNode() {
        TreeNode<Integer, Character> root = new TreeNode<>(6, 'A');
        TreeNode node = new TreeNode<>(5, 'B');
        root.left = node;
        node.left = new TreeNode(7, 'C');
        node.left.left = new TreeNode(8, 'E');
        node.right = new TreeNode(4, 'D');
        node = node.right;
        node.left = new TreeNode(3, 'F');
        node.left.left = new TreeNode(2, 'H');
        node.right = new TreeNode(9, 'G');
        node.right.left = new TreeNode(10, 'I');
        node.right.left.left = new TreeNode(1, 'J');
        return root;
    }

    @Test
    public void nodes() {
        TreeNode<Integer, Character> root = createNode();

        root.nodes(TreeNode.IteratePattern.Pre);
        root.nodes(TreeNode.IteratePattern.In);
        root.nodes(TreeNode.IteratePattern.Post);

    }

    @Test
    public void check() {
        Assert.assertFalse(createNode().check());
    }
}