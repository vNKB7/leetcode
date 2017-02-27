#!/usr/bin/env python2

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

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

'''
# 484sa
class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        p1 = node
        p2 = node.next

        while p2.next:
            p1.val, p1, p2 = p2.val, p2, p2.next

        p1.val = p2.val
        p1.next = None
'''
class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next

head = getList([1,2,3,4,5,6])
s = Solution()
s.deleteNode(head.next.next)
printNode(head)
