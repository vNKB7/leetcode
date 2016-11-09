#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):#实际上是一个中序遍历
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        curNode = root
        preVal = -1000000000000000
        queue = []

        while len(queue) > 0 or curNode is not None:
            while curNode is not None:
                queue.append(curNode)
                curNode = curNode.left

            curNode = queue.pop()

            if curNode.val < preVal:
                return False
            else:
                preVal = curNode.val

            curNode = curNode.right

        return True
s = Solution()

a = TreeNode(1)
b = TreeNode(2)
c = TreeNode(3)
a.right = b
b.left = c

print(s.isValidBST(a))



