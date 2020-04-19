# https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteDuplicates(self, head):
        if head is None:
            return head
        pre = ListNode(None)
        pre.next = head

        p = pre
        while p is not None:
            duplicateFlag = False
            while p.next is not None and p.next.next is not None and p.next.val == p.next.next.val:
                duplicateFlag = True
                p.next.next = p.next.next.next
            if duplicateFlag:
                p.next = p.next.next
            else:
                p = p.next
        return pre.next

    def init(self, array):
        head = ListNode(0)
        p = head
        for i in array:
            p.next = ListNode(i)
            p = p.next
        return head.next

sol = Solution()
head = sol.init([1,1,1,2,3])
res=sol.deleteDuplicates(head)
while res is not None:
    print(res.val,end=', ')
    res = res.next