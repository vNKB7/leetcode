#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head:
            return

        #1.count ListNode in head
        count = 0
        cur = head
        while cur:
            count += 1
            cur = cur.next

        if count == 1:
            return

        #2.split the list in half
        first_part = head
        second_part = head
        for i in range(count - count // 2 - 1):
            second_part = second_part.next
        tmp = second_part
        second_part = second_part.next
        tmp.next = None

        #3.reverse the second part of the list
        if second_part.next:
            slow = second_part
            fast = second_part.next
            slow.next = None
            while fast:
                temp = fast.next
                fast.next = slow
                slow = fast
                fast = temp

            second_part = slow


        #4. merge the two halves
        temp = ListNode(0)
        temp.next = first_part
        while True:
            if not first_part:
                break
            temp.next = first_part
            temp = temp.next
            first_part = first_part.next

            if not second_part:
                break
            temp.next = second_part
            temp = temp.next
            second_part = second_part.next


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

head = getList([1,2,3,4,5,6,7,8,9])
s = Solution()
s.reorderList(head)
printNode(head)