#!/usr/bin/env python

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if not head:
            return None

        pesudoHead1 = ListNode(-1)
        pesudoHead2 = ListNode(-1)

        pesudoHead1.next = head

        while pesudoHead1.next:
            cur = pesudoHead1.next
            pesudoHead1.next = pesudoHead1.next.next
            cur.next = pesudoHead2.next
            pesudoHead2.next = cur

        return pesudoHead2.next

