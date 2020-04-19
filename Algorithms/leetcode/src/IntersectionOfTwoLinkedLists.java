// https://leetcode.com/problems/intersection-of-two-linked-lists/description/

public class IntersectionOfTwoLinkedLists {
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a != null) a = a.next;
            else a = headB;

            if (b != null) b = b.next;
            else b = headA;
        }
        return a;
    }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0, bLen = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        while (curB != null) {
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if (aLen > bLen) {
            for (int i = aLen - bLen; i > 0; i--) {
                curA = curA.next;
            }
        } else {
            for (int i = bLen - aLen; i > 0; i--) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
