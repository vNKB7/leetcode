#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        if not root:
            return []

        result = []
        queue = []
        queue.append((root, 1))
        curLevel = 0

        while len(queue) > 0:
            node, level = queue.pop(0)
            if level > curLevel:
                result.append(node.val)
                curLevel = level
            if node.right:
                queue.append((node.right, curLevel + 1))
            if node.left:
                queue.append((node.left, curLevel + 1))

        return result
