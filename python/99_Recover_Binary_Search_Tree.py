#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        nodeList = [0] * 3
        stat = 0
        preNode = None

        curNode = root
        preVal = -1000000000000000
        queue = []

        while len(queue) > 0 or curNode is not None:
            while curNode is not None:
                queue.append(curNode)
                curNode = curNode.left

            curNode = queue.pop()

            if stat == 0:
                if curNode.val < preVal:
                    nodeList[0] = preNode
                    nodeList[1] = curNode
                    stat += 1
                preVal = curNode.val
            elif stat == 1:
                if curNode.val < preVal:
                    nodeList[2] = curNode
                    stat += 1
                    break

            preNode = curNode
            curNode = curNode.right

        if stat == 1:
            nodeList[0].val, nodeList[1].val = nodeList[1].val, nodeList[0].val
        elif stat == 2:
            nodeList[0].val, nodeList[2].val = nodeList[2].val, nodeList[0].val



s = Solution()

a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(1)
a.left = b
a.right = c
s.recoverTree(a)
print(a.val, b.val, c.val)


