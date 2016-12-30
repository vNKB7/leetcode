#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None

        path_A = 0
        path_B = 0

        cur = headA
        while cur:
            path_A += 1
            cur = cur.next

        cur = headB
        while cur:
            path_B += 1
            cur = cur.next

        offset = path_A - path_B
        if offset > 0:
            while offset > 0:
                headA = headA.next
                offset -= 1
        if offset < 0:
            offset = -offset
            while offset > 0:
                headB = headB.next
                offset -= 1

        while headA and headB and headA != headB:
            headA = headA.next
            headB = headB.next

        if headA and headA == headB:
            return headA
        else:
            return None


