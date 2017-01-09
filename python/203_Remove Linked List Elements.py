#!/usr/bin/env python
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeElements(self, head, val):
        pesudoHead = ListNode(-1)
        pesudoHead.next = head
        cur = pesudoHead

        while cur.next:
            if cur.next.val == val:
                cur.next = cur.next.next
            else:
                cur = cur.next

        return pesudoHead.next

