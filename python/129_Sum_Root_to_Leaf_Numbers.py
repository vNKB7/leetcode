#!/usr/bin/env python3
from TreeMethod import *

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        return self.helper(root, root.val)


    def helper(self, root, value):
        leftVal = rightVal = 0

        if not root.left and not root.right:
            return value

        if root.left:
            leftVal = self.helper(root.left, value * 10 + root.left.val)

        if root.right:
            rightVal = self.helper(root.right, value * 10 + root.right.val)

        return leftVal + rightVal

root = build([1,2,3])
s = Solution()
print(s.sumNumbers(root))
