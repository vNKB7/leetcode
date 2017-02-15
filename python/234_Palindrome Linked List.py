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
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:
            return True
        length, end, cur = 1, None, head
        while cur.next:
            cur = cur.next
            length += 1
        end = cur

        middle = (length + 1) / 2
        cur = head
        for i in range(middle-1):
            cur = cur.next

        cur2 = cur.next
        cur.next = None
        while cur2:
            tmp = cur2.next
            cur2.next = cur
            cur = cur2
            cur2 = tmp

        while head and (head.next or head.next != end.next and head.next != end):
            if head.val != end.val:
                return False
            else:
                head = head.next
                end = end.next

        return True
'''
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        rev = None
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            # tmp = rev
            # rev = slow
            # rev.next = tmp
            # slow = slow.next
            rev, rev.next, slow = slow, rev, slow.next

        if fast:
            slow = slow.next

        while rev and rev.val == slow.val:
            slow = slow.next
            rev = rev.next

        return not rev




head = getList([1,2,2,1])
s = Solution()
print s.isPalindrome(head)
