#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """

        tmpHead = ListNode(0)
        fakeHead = ListNode(0)
        fakeHead.next = head
        splitPoint = cur = fakeHead
        findSplit = False
        i = 1
        while i < n+2:
            if not findSplit:
                if i == m:
                    splitPoint = cur
                    findSplit = True
                    splitTail = cur.next
                cur = cur.next
            else:
                next = cur.next
                cur.next = tmpHead.next
                tmpHead.next = cur
                cur = next
            i += 1

        splitPoint.next = tmpHead.next
        splitTail.next = cur
        return fakeHead.next

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
head = getList([1,2,3,4,5])
head = s.reverseBetween(head, 2, 4)
printNode(head)