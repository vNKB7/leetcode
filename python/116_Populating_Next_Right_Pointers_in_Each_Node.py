#!/usr/bin/env python3

# Definition for binary tree with next pointer.
class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


# not a solution with O(1) in space
'''
class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):

        if not root:
            return

        nextQueue = []
        curQueue = []

        curQueue.append(root)

        point = None
        while len(curQueue) > 0:
            if not point:
                point = curQueue.pop(0)
            else:
                point.next = curQueue.pop(0)
                point = point.next

            if point.left:
                nextQueue.append(point.left)
                nextQueue.append(point.right)

            if len(curQueue) == 0:
                point.next = None
                point = None
                curQueue = nextQueue
                nextQueue = []
'''

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):

        if not root:
            return

        checkPoint = root

        while checkPoint.left:
            cur = checkPoint
            while True:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                    cur = cur.next
                else:
                    cur.right.next = None
                    break

            checkPoint = checkPoint.left




