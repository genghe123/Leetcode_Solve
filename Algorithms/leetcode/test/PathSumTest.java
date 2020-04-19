import static org.junit.Assert.*;

public class PathSumTest {

    private PathSum pathSum=new PathSum();

    @org.junit.Test
    public void hasPathSum() {
        assertFalse(pathSum.hasPathSum(null,0));
        assertTrue(pathSum.hasPathSum(TreeNode.constructTreeNode("5,4,8,11,null,13,4,7,2,null,null,null,1"),22));
        assertFalse(pathSum.hasPathSum(TreeNode.constructTreeNode("1,2"),1));
    }
}