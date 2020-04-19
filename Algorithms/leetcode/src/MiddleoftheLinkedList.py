# https://leetcode.com/problems/middle-of-the-linked-list/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def middleNode(self, head):
        if head is None:
            return None
        elif head.next is None:
            return head.val
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow


    def init(self, array):
        head = ListNode(0)
        p = head
        for i in array:
            p.next = ListNode(i)
            p = p.next
        return head.next