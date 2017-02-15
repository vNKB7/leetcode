#!/usr/bin/env python2

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        p, q = min(p.val, q.val), max(p.val, q.val)
        cur = root
        while cur.val != p and cur.val != q and not (p < cur.val < q):
            if q < cur.val:
                cur = cur.left
            else:
                cur = cur.right

        return cur
