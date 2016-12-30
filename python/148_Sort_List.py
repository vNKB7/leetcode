#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


# 用merge sort 试试

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return []

        parts = self.divide(head)
        if not parts:
            if head.next and head.val > head.next.val:
                tmp = head.next
                head.next.next = head
                head.next = None
                head = tmp
            return head
        else:
            firstPart = self.sortList(parts[0])
            secondPart = self.sortList(parts[1])
            merged = self.merge(firstPart, secondPart)
            return merged

    def divide(self, head):
        size = 0
        cur = head
        while cur:
            size += 1
            cur = cur.next

        if size <= 2:
            return None

        first_part = size // 2
        size = 0
        cur = head
        while size < first_part:
            cur = cur.next
            size += 1
        second = cur.next
        cur.next = None

        return head, second

    def merge(self, first, second):
        pseudoHead = ListNode(0)
        p = pseudoHead

        while first and second:
            if first.val < second.val:
                p.next = first
                p = p.next
                first = first.next
            else:
                p.next = second
                p = p.next
                second = second.next
        if first:
            p.next = first
        else:
            p.next = second

        return pseudoHead.next



def getList(myList):
    head = ListNode(myList[0])
    cur = head
    for num in myList[1:]:
        cur.next = ListNode(num)
        cur = cur.next
    return head

def printNode(head):
    while head is not None:
        print(head.val)
        head = head.next

s = Solution()
head = getList([])

head = s.sortList(head)
printNode(head)
