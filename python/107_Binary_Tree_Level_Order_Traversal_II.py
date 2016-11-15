#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
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

        trueResult = result[::-1]
        return trueResult

