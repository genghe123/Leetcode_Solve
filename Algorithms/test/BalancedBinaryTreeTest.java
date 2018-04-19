import org.junit.Assert;
import org.junit.Test;

public class BalancedBinaryTreeTest {

    private BalancedBinaryTree binaryTree = new BalancedBinaryTree();

    @Test
    public void isBalanced() {
        Assert.assertTrue(binaryTree.isBalanced(TreeNode.constructTreeNode("1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5")));
        Assert.assertFalse(binaryTree.isBalanced(TreeNode.constructTreeNode("3,1,null,null,2")));
        Assert.assertFalse(binaryTree.isBalanced(TreeNode.constructTreeNode("1,2,2,3,3,null,null,4,4")));
        Assert.assertTrue(binaryTree.isBalanced(TreeNode.constructTreeNode("3,9,20,null,null,15,7")));

    }
}