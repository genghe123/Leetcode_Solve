import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListCycleTest {

    private LinkedListCycle linkedListCycle = new LinkedListCycle();

    @Test
    public void hasCycle() {
        assertFalse(linkedListCycle.hasCycle(ListNode.constructListNode(new int[]{1, 2})));
        assertFalse(linkedListCycle.hasCycle(ListNode.constructListNode(new int[]{1, 1, 1})));
        assertFalse(linkedListCycle.hasCycle(null));

        ListNode node = new ListNode(0);
        assertTrue(linkedListCycle.hasCycle(ListNode.constructListNode(new ListNode[]{node, new ListNode(1), node})));
        assertTrue(linkedListCycle.hasCycle(ListNode.constructListNode(new ListNode[]{node, node})));
    }
}