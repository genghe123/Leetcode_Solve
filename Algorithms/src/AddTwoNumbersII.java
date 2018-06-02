// https://leetcode.com/problems/add-two-numbers-ii/description/

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int sum = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) sum += stack1.pop();
            if (!stack2.empty()) sum += stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            sum /= 10;
        }
        if (sum > 0) {
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }

}
