#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None



# recursively
'''
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True

        if root.left is None and root.right is None:
            return True

        if (root.left is None) ^ (root.right is None):
            return False
        return self.helper(root.left, root.right)

    def helper(self, p, q):
        flagL = flagR = True

        if p.val != q.val:
            return False

        if ((p.left is None) ^ (q.right is None)) or ((p.right is None) ^ (q.left is None)):
            return False

        if p.left is not None:
            flagL = self.helper(p.left, q.right)

        if p.right is not None:
            flagR = self.helper(p.right, q.left)

        return flagL and flagR
'''

# iteratively
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True

        if root.left is None and root.right is None:
            return True

        if (root.left is None) ^ (root.right is None):
            return False

        queueL = []
        queueR = []
        curL = root.left
        curR = root.right

        while len(queueL) > 0 and len(queueR) > 0 or (curL is not None or curR is not None):
            while curL is not None and curR is not None:
                queueL.append(curL)
                queueR.append(curR)
                curL = curL.left
                curR = curR.right
            if curL is not None or curR is not None:
                return False
            if len(queueL) == 0 or len(queueR) == 0:
                return False

            curL = queueL.pop()
            curR = queueR.pop()

            if curL.val != curR.val:
                return False

            curL = curL.right
            curR = curR.left

        return True

s = Solution()

a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(4)
f = TreeNode(5)
a.left = b
a.right = c
b.left = d
b.right = f
c.right = e

print(s.isSymmetric(a))




