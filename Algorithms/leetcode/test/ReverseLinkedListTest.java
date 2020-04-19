import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {

    private ReverseLinkedList reverse = new ReverseLinkedList();

    @Test
    public void reverseList() {
        assertEquals(ListNode.constructListNode(new int[]{5, 4, 3, 2, 1}).toString(), reverse.reverseList(ListNode.constructListNode(new int[]{1, 2, 3, 4, 5})).toString());
    }
}