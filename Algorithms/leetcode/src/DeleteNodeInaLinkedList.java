// https://leetcode.com/problems/delete-node-in-a-linked-list/description/

public class DeleteNodeInaLinkedList {
    public void deleteNode(ListNode node) {
        if (node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
