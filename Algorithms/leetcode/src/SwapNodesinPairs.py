# https://leetcode.com/problems/swap-nodes-in-pairs/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def swapPairs(self, head):
        if head is None or head.next is None:
            return head
        
        preHead = ListNode(0)
        preHead.next = head

        first, second, third = preHead, head, head.next
        while second is not None and third is not None:
            second.next = third.next
            third.next = second
            first.next = third
            
            first = second
            second = second.next
            third = second.next if second is not None else None
        return preHead.next