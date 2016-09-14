#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """

        if head is None:
            return None

        tail = head
        len = 1

        while tail.next is not None:
            tail = tail.next
            len += 1

        if k % len == 0:
            return head

        tail.next = head
        move = len - k % len - 1

        while move > 0:
            head = head.next
            move -= 1

        tail = head
        head = head.next
        tail.next = None
        return head





def getList(nums):
    head = ListNode(nums[0])
    cur = head
    for n in nums[1:]:
        cur.next = ListNode(n)
        cur = cur.next
    return head

def show(ln):
    cur = ln
    while cur is not None:
        print(cur.val)
        cur = cur.next


s = Solution()
show(s.rotateRight(getList([1,2,3]), 1))

