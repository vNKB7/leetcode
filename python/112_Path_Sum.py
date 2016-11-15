#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root is None:
            return False
        return self.helper(root, 0, sum)

    def helper(self, root, curSum, sum):
        if root is None:
            if curSum == sum:
                return True
            else:
                return False

        if root.left is None and root.right is not None:
            return self.helper(root.right, curSum + root.val, sum)
        elif root.right is None and root.left is not None:
            return self.helper(root.left, curSum + root.val, sum)

        return self.helper(root.left, curSum + root.val, sum) or self.helper(root.right, curSum + root.val, sum)








