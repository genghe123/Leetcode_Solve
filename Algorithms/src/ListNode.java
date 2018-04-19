public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode constructListNode(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]), current = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        return head;
    }

    public static ListNode constructListNode(ListNode[] nodes) {
        if (nodes == null || nodes.length == 0) return null;
        for (int i = nodes.length - 2; i >= 0; i--) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        ListNode node = constructListNode(new int[]{1, 2, 3});
        System.out.println(node.toString());

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            stringBuilder.append(node.val);
            stringBuilder.append(",");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
