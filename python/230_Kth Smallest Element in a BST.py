#!/usr/bin/env python2

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """

        stack = []
        cur = root

        while cur or len(stack) > 0:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop(-1)
            k -= 1
            if k == 0:
                return cur.val
            cur = cur.right
