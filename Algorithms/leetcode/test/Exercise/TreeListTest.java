package Exercise;

import org.junit.Assert;
import org.junit.Test;

public class TreeListTest {

    private TreeList<Integer> tree = new TreeList<>(19);

    @Test
    public void insert() {
    }

    @Test
    public void left() {
        Assert.assertEquals(2, tree.left(1));
        Assert.assertEquals(18, tree.left(9));
        Assert.assertEquals(16, tree.left(8));
        Assert.assertEquals(12, tree.left(6));
        Assert.assertEquals(-1, tree.left(10));
        Assert.assertEquals(-1, tree.left(15));
    }

    @Test
    public void right() {
        Assert.assertEquals(3, tree.right(1));
        Assert.assertEquals(19, tree.right(9));
        Assert.assertEquals(17, tree.right(8));
        Assert.assertEquals(13, tree.right(6));
        Assert.assertEquals(-1, tree.right(10));
        Assert.assertEquals(-1, tree.right(15));
    }

    @Test
    public void parent() {
        Assert.assertEquals(0, tree.parent(1));
        Assert.assertEquals(4, tree.parent(9));
        Assert.assertEquals(4, tree.parent(8));
        Assert.assertEquals(3, tree.parent(6));
        Assert.assertEquals(5, tree.parent(10));
        Assert.assertEquals(7, tree.parent(15));
        Assert.assertEquals(-1, tree.parent(20));

    }

    @Test
    public void commonAncestor() {
        Assert.assertEquals(8, tree.commonAncestor(16, 8));
        Assert.assertEquals(8, tree.commonAncestor(8, 16));
        Assert.assertEquals(4, tree.commonAncestor(16, 4));
        Assert.assertEquals(4, tree.commonAncestor(4, 16));
        Assert.assertEquals(2, tree.commonAncestor(16, 2));
        Assert.assertEquals(1, tree.commonAncestor(1, 16));
        Assert.assertEquals(1, tree.commonAncestor(16, 1));
        Assert.assertEquals(1, tree.commonAncestor(12, 16));
        Assert.assertEquals(4, tree.commonAncestor(16, 9));
        Assert.assertEquals(4, tree.commonAncestor(9, 16));
        Assert.assertEquals(3, tree.commonAncestor(13, 15));
        Assert.assertEquals(5, tree.commonAncestor(5, 5));
        Assert.assertEquals(1, tree.commonAncestor(1, 1));

    }
}