#!/usr/bin/env python3
import copy
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        result = []


    def helper(self, root, curRoot, curIndex, maxIndex, resultList):
        if curIndex == maxIndex:
            resultList.append(root)
            return
        leftRoot = TreeNode()
        rightRoot = TreeNode()

        leftCur = self.myCopy(root, leftRoot, curRoot)
        rightCur = self.myCopy(root, rightRoot, curRoot)

        


    def myCopy(self, root, newRoot, target):
        newRoot.val = root.val
        result1 = result2 = None
        if root.left is not None:
            newRoot.left = TreeNode()
            result1 = self.myCopy(root.left, newRoot.left, target)
        if root.right is not None:
            newRoot.right = TreeNode()
            result2 = self.myCopy(root.right, newRoot.right, target)

        if root == target:
            return newRoot
        elif result1 is not None:
            return result1
        elif result2 is not None:
            return result2
        else:
            return None














s = Solution()

a = TreeNode('a')
b = TreeNode('b')
c = TreeNode('c')
a.right = b
b.left = c

