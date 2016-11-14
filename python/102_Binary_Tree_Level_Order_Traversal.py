#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
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
            result.append(tmpList)
            queue = newQueue
        return result

s = Solution()

a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(4)
f = TreeNode(5)
a.left = b
a.right = c
b.left = d
b.right = f
c.right = e
print(s.levelOrder(a))







