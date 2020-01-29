# https://leetcode.com/problems/populating-next-right-pointers-in-each-node/


# Definition for a Node.
class Node:
    def __init__(self,
                 val: int = 0,
                 left: 'Node' = None,
                 right: 'Node' = None,
                 next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


import queue


class Solution:
    def connect2(self, root: 'Node') -> 'Node':
        if not root: return root
        q = queue.Queue()
        q.put(root)

        next = 1
        cnt = 0
        pre = None
        while not q.empty():
            node = q.get()
            if node is None: continue
            cnt += 1
            if next == cnt:
                next *= 2
            else:
                pre.next = node
            pre = node
            q.put(node.left)
            q.put(node.right)
        return root

    # 重点！
    def connect(self, root: 'Node') -> 'Node':
        if not root: return root
        current  = root
        while current:
            if current.left:
                current.left.next = current.right
            if current.right:
                current.right.next = current.next and current.next.left
            current = current.next
        self.connect(root.left)
        return root


if __name__ == "__main__":
    sol = Solution()
    root = Node(1, Node(2), Node(3))
    sol.connect(root)
    print(root)