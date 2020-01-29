# https://leetcode.com/problems/kth-smallest-element-in-a-bst/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: return 
        self.k = k
        self.res = None
        self.inOrder(node=root)
        return self.res

    def inOrder(self, node):
        if not node: return
        self.inOrder(node.left)
        self.kk -= 1
        if self.k == 0:
            self.res = node.val
        self.inOrder(node.right)
