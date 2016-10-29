#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head is None:
            return None

        fakeHead = ListNode(0)
        fakeHead.next = head
        slow = fakeHead
        fast = head

        while fast is not None:
            if slow.next.val != fast.val:
                if slow.next.next is not fast:
                    slow.next = fast
                else:
                    slow = slow.next
            fast = fast.next
        if slow.next is not None:
            if slow.next.next is not None:
                slow.next = None

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

head = getList([1,1,3,3,4])
s = Solution()
nodelist = s.deleteDuplicates(head)
printNode(nodelist)
