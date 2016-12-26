#!/usr/bin/env python3

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# 如果使用快慢指针的话，时间复杂度为O(n)，额外空间复杂度为O(1)
# 快指针一次走2，慢指针一次走1。经过t时间，快指针走2t，慢指针走t。路程差为t。令环长度为L。只需t=L时间即可相遇。所以下面的循环中可以少比较一次。
class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        if not head:
            return False

        if not head.next:
            return False

        fast = head.next
        slow = head

        while fast:
            if fast == slow:
                return True

            fast = fast.next

            if not fast:
                return False

            if fast == slow:
                return True

            fast = fast.next
            slow = slow.next

        return False