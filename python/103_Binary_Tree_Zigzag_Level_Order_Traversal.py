#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        if root is None:
            return []

        zigzag = False
        queue = []
        queue.append(root)
        result = []

        while len(queue) > 0:
            newQueue = []
            tmpList = []
            for node in queue:
                tmpList.append(node.val)
                if node.left is not None:
                    newQueue.append(node.left)
                if node.right is not None:
                    newQueue.append(node.right)
            if zigzag:
                tmpList.reverse()
            zigzag = not zigzag

            result.append(tmpList)
            queue = newQueue
        return result


s = Solution()

a = TreeNode(1)
b = TreeNode(2)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(5)
f = TreeNode(6)
a.left = b
a.right = c
b.left = d
b.right = f
c.right = e
print(s.zigzagLevelOrder(a))
