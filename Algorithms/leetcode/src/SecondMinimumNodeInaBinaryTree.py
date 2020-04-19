# https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        if not root: return -1
        self.first = self.second = float('inf')

        self.inOrder(root)
        return -1 if self.second == float('inf') else self.second

    def inOrder(self, node):
        if not node: return
        self.inOrder(node.left)
        val = node.val
        if val < self.first:
            self.second = self.first
            self.first = val
        elif self.first < val < self.second:
            self.second = val
        self.inOrder(node.right)


if __name__ == "__main__":
    sol = Solution()
    sol.findSecondMinimumValue(TreeNode(2))