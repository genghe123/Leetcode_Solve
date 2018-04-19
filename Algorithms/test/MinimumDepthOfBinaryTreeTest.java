import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthOfBinaryTreeTest {

    private MinimumDepthOfBinaryTree minimumDepth = new MinimumDepthOfBinaryTree();

    @Test
    public void minDepth() {
        assertEquals(0, minimumDepth.minDepth(null));
        assertEquals(2, minimumDepth.minDepth(TreeNode.constructTreeNode("1,2")));
        assertEquals(3, minimumDepth.minDepth(TreeNode.constructTreeNode("1,2,2,3,3,null,3,4,4")));
    }
}