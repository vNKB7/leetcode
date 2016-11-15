#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if head is None:
            return None

        cur = TreeNode(head.val)
        head = head.next
        queue = []
        maxDep = 1
        dep = 1
        while head is not None:
            if maxDep == dep:#
                (cur, dep) = queue.pop()
                tmp = TreeNode(head.val)
                tmp.left = cur
                cur = tmp
                queue.append((cur, dep))
                maxDep += 1
            else:
                (cur, dep) = queue.pop()
                tmp = TreeNode(head.val)
                cur.right = tmp
                cur = tmp
                dep += 1


            head = head.next





