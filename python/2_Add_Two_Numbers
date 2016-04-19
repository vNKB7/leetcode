#!/usr/bin/env python

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        # result = ListNode(0)
        #
        # p1 = l1
        # p2 = l2
        # res = result
        # add = 0
        #
        # while True:
        #     [add, res.val] = divmod(p1.val + p2.val + add, 10)
        #     if p1.next != None or p2.next != None:
        #         res.next = ListNode(0)
        #         if p1.next == None:
        #             p1 = ListNode(0)
        #         else:
        #             p1 = p1.next
        #         if p2.next == None:
        #             p2 = ListNode(0)
        #         else:
        #             p2 = p2.next
        #         res = res.next
        #     else:
        #         if add > 0:
        #             next = ListNode(add)
        #             res.next = next
        #         break
        # return result


        result = ListNode(0)

        p1 = l1
        p2 = l2
        res = result
        add = 0


        while p1 != None or p2 != None or add != 0:
            [add, mod] = divmod((p1.val if p1 != None else 0) + (p2.val if p2 != None else 0) + add, 10)
            res.next = ListNode(mod)
            if p1 != None:
                p1 = p1.next
            if p2 != None:
                p2 = p2.next
            res = res.next

        return result.next

a1 = ListNode(2)
a1.next = ListNode(4)
a1.next.next = ListNode(3)

a2 = ListNode(5)
a2.next = ListNode(6)
a2.next.next = ListNode(4)

s = Solution()
result = s.addTwoNumbers(a1, a2)

p = result
while p != None:
    print(p.val)
    p = p.next