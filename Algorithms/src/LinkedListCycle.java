// https://leetcode.com/problems/linked-list-cycle/description/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /*
        Two Pointers : Fast and Slow Pointers
        The space complexity can be reduced to O(1) by considering two pointers at different speed
        - a slow pointer and a fast pointer. The slow pointer moves one step at a time while the fast
        pointer moves two steps at a time.

        If there is no cycle in the list, the fast pointer will eventually reach the end and we can
        return false in this case.
        Now consider a cyclic list and imagine the slow and fast pointers are two runners racing
        around a circle track. The fast runner will eventually meet the slow runner.
        Why? Consider this case (we name it case A) - The fast runner is just one step behind the
        slow runner. In the next iteration, they both increment one and two steps respectively and meet each other.

        How about other cases? For example, we have not considered cases where the fast runner is
        two or three steps behind the slow runner yet. This is simple, because in the next or next's
        next iteration, this case will be reduced to case A mentioned above.
         */

        if (head == null || head.next == null) return false;
        // Mention that while loop condition is "slow != fast", so when initialing fast and slow
        // should not be same.
        ListNode fast = head.next, slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
