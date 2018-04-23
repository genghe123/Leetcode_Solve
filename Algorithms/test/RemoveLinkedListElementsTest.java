import org.junit.Test;


import static org.junit.Assert.*;

public class RemoveLinkedListElementsTest {

    private RemoveLinkedListElements remove = new RemoveLinkedListElements();

    @Test
    public void removeElements() {
        assertEquals(ListNode.constructListNode(new int[]{1, 2, 3, 4, 5}).toString(), remove.removeElements(ListNode.constructListNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6).toString());

    }
}