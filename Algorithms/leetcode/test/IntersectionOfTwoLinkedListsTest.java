import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {

    private IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists();
    private ListNode commonNode = ListNode.constructListNode(new int[]{3, 3, 3});

    @Test
    public void Separate() {
        Assert.assertNull(intersection.getIntersectionNode(commonNode, ListNode.constructListNode(new int[]{3, 3, 3, 3})));
    }

    @Test
    public void Separate2Intersect() {
        ListNode a = ListNode.constructListNode(new ListNode[]{new ListNode(0), new ListNode(0), commonNode});
        ListNode b = ListNode.constructListNode(new ListNode[]{new ListNode(1), commonNode});

        String aInit = a.toString();
        String bInit = b.toString();

        Assert.assertEquals(commonNode, intersection.getIntersectionNode(a, b));
        Assert.assertEquals(aInit, a.toString());
        Assert.assertEquals(bInit, b.toString());
    }

    @Test
    public void Intersect2Separate() {
        ListNode a = ListNode.constructListNode(new ListNode[]{new ListNode(0), commonNode, new ListNode(0)});
        ListNode b = ListNode.constructListNode(new ListNode[]{commonNode, new ListNode(1)});
    }
}