# https://leetcode.com/problems/binary-tree-right-side-view/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # DFS + recursively
    def rightSideView(self, root):
        if not root: return []
        res = []
        self.dfs(root, 1, res)
        return res

    def dfs(self, root, level, res):
        if root:
            if len(res) < level:
                res.append(root.val)
            self.dfs(root.right, level + 1, res)
            self.dfs(root.left, level + 1, res)

    # BFS + queue
    def rightSideView2(self, root):
        if not root: return []
        res, queue = [], [(root, 0)]
        while queue:
            curr, level = queue.pop(0)
            if curr:
                if len(res) < level:
                    res.append(curr.val)
                queue.append((curr.right, level + 1))
                queue.append((curr.left, level + 1))
        return res

    # DFS + stack
    def rightSideView3(self, root):
        res, stack = [], [(root, 0)]
        while stack:
            curr, level = stack.pop()
            if curr:
                if len(res) < level:
                    res.append(curr.val)
                stack.append((curr.right, level + 1))
                stack.append(curr.left, level + 1)
