#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None:
            return 0
        else:
            left = self.minDepth(root.left)
            right = self.minDepth(root.right)

        if left == 0 and right != 0:
            return right + 1
        if left != 0 and right == 0:
            return left + 1

        return min(left, right) + 1

a = TreeNode(1)
b = TreeNode(2)
a.left = b
s = Solution()
print(s.minDepth(a))






