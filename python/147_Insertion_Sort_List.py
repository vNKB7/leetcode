#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None

        pseudoHead = ListNode(0)
        pseudoHead.next = head
        p1 = head.next
        head.next = None

        while p1:
            p2 = pseudoHead
            tmp = p1.next
            while p2.next and p1.val > p2.next.val:
                p2 = p2.next
            p1.next= p2.next
            p2.next = p1
            p1 = tmp

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
head = getList([3,2,5,1,10,2,3,1])
printNode(s.insertionSortList(head))