# https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def sortedListToBST(self, head):
        vals = self.mapListToArray(head)
        root = self.construct(vals, 0, len(vals) - 1)
        return root
    
    def construct(self, head, left, right):
        if left > right:
            return None
        mid = left + ((right - left) >> 1)
        node = TreeNode(head[mid])
        node.left = self.construct(head, left, mid - 1)
        node.right = self.construct(head, mid + 1, right)
        return node

    def mapListToArray(self, head):
        vals = []
        while head:
            vals.append(head.val)
            head = head.next
        return vals

    def init(self, array):
        head = ListNode(0)
        p = head
        for i in array:
            p.next = ListNode(i)
            p = p.next
        return head.next

sol = Solution()
array = sol.init([-10, -3, 0, 5, 9])
sol.sortedListToBST(array)