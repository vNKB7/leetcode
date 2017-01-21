#!/usr/bin/env python2
class LinkedNode(object):
    def __init__(self, value):
        self.previous = None
        self.next = None
        self.val = value

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        self.pesudoHead = LinkedNode(-1)
        self.size = 0
        self.capacity = k

        for n in nums:
            self.insert(n)

        return self.pesudoHead.previous.val

    def insert(self, value):
        new_node = LinkedNode(value)
        if self.size < self.capacity:
            if not self.pesudoHead.next:
                self.pesudoHead.next = new_node
                self.pesudoHead.previous = new_node
                self.size += 1
                return
            elif self.pesudoHead.previous.val >= value:
                self.pesudoHead.previous.next = new_node
                new_node.previous = self.pesudoHead.previous
                self.pesudoHead.previous = new_node
                self.size += 1
                return
            else:
                cur = self.pesudoHead
                while cur.next:
                    if cur.next.val <= value:
                        new_node.next = cur.next
                        new_node.previous = cur
                        cur.next = new_node
                        new_node.next.previous = new_node
                        self.size += 1
                        return
                    cur = cur.next
        elif self.pesudoHead.previous.val >= value:
            return
        else:
            cur = self.pesudoHead
            while cur.next:
                if cur.next.val <= value:
                    new_node.next = cur.next
                    new_node.previous = cur
                    cur.next = new_node
                    new_node.next.previous = new_node
                    break
                cur = cur.next
            self.pesudoHead.previous.previous.next = None
            self.pesudoHead.previous = self.pesudoHead.previous.previous

s = Solution()
print s.findKthLargest([-1,2,0],2)