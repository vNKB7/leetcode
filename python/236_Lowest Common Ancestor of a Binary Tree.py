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
        if not root:
            return False
        self_match = root == p or root == q
        left_match = self.lowestCommonAncestor(root.left, p, q)
        right_match = self.lowestCommonAncestor(root.right, p, q)
        result = [self_match, left_match, right_match]
        if len([x for x in result if type(x) != bool]) > 0:
            return [x for x in result if type(x) != bool][0]
        elif len([x for x in result if x]) == 2:
            return root
        elif len([x for x in result if x]) == 1:
            return True
        else:
            return False


