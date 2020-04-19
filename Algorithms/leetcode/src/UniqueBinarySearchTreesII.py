# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return '[' + str(self.left) + ',' + str(self.val) + ',' + str(
            self.right) + ']'


class Solution:
    def generateTrees(self, n):
        ans = self.generateSubTrees(0, n)
        return ans

    def generateSubTrees(self, start, end):
        subTree = []
        if start > end: return subTree
        if start == end:
            subTree.append(TreeNode(start))
            return subTree

        left, right = [], []

        for i in range(start, end + 1):
            left = self.generateSubTrees(start, i - 1)
            right = self.generateSubTrees(i + 1, end)

            for leftTree in left:
                for rightTree in right:
                    subRoot = TreeNode(i)
                    subRoot.left = leftTree
                    subRoot.right = rightTree
                    subTree.append(subRoot)
                    print(subRoot)

        return subTree


if __name__ == "__main__":
    sol = Solution()
    ans = sol.generateTrees(1)
    print(ans)