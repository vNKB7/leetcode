#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack = []
        cur = root
        result = []

        while cur or len(stack) > 0:
            if not cur:
                cur = stack.pop(-1)
                cur = cur.right
            else:
                result.append(cur.val)
                stack.append(cur)
                cur = cur.left

        return result


