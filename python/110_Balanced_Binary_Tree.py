#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

'''
#感觉有更漂亮的方法
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True

        dep , flag = self.helper(root)
        return flag

    def helper(self, root):
        flag = True
        if root.left is None:
            leftH = 0
        else:
            (leftH, flag) = self.helper(root.left)

        if not flag:
            return (0, False)

        if root.right is None:
            rightH = 0
        else:
            (rightH, flag) = self.helper(root.right)

        if not flag:
            return (0, False)

        if abs(leftH - rightH) > 1:
            return (0, False)
        else:
            return (max(leftH, rightH) + 1, True)
'''

#??????但是并不对
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True

        maxHeight, minHeight = self.helper(root)
        if maxHeight - minHeight > 1:
            return False
        else:
            return True

    def helper(self, root):
        leftMax = leftMin = rightMax = rightMin = 0

        if root.left is not None:
            (leftMax, leftMin) = self.helper(root.left)

        if root.right is not None:
            (rightMax, rightMin) = self.helper(root.right)

        return (max(leftMax, rightMax) + 1, min(leftMin, rightMin) + 1)




