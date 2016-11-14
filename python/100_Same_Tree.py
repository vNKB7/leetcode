#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p is None and q is None:
            return True
        if (p is None) ^ (q is None):
            return False
        return self.helper(p, q)

    def helper(self, p, q):
        flagL = flagR = True

        if p.val != q.val:
            return False

        if ((p.left is None) ^ (q.left is None)) or ((p.right is None) ^ (q.right is None)):
            return False

        if p.left is not None:
            flagL = self.helper(p.left, q.left)

        if p.right is not None:
            flagR = self.helper(p.right, q.right)

        return flagL and flagR





