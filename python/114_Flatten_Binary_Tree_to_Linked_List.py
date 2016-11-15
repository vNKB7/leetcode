#!/usr/bin/env python3

import TreeMethod

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None

        cur = root
        stack = []
        stackR = []
        point = TreeNode(0)

        while len(stack) > 0 or cur:
            while cur:
                point.right = cur
                point = cur
                tmp = cur
                stack.append(cur)
                cur = cur.left
                tmp.left = None
                stackR.append(tmp.right)

            stack.pop()
            cur = stackR.pop()
        return root

s = Solution()
print(TreeMethod.show(s.flatten(TreeMethod.build([0]))))

