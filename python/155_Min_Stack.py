#!/usr/bin/env python3

# import DoubleLinkList
#
# class MinStack(object):
#
#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.PseudoHead = self.DoubleLinkList(-1)
#         self.PseudoTail = self.PseudoHead
#         self.MinList = []
#         self.size = 0
#
#
#     def push(self, x):
#         """
#         :type x: int
#         :rtype: void
#         """
#         newNode = self.DoubleLinkList(x)
#         newNode.next = self.PseudoTail.next
#         newNode.pre = self.PseudoTail
#         self.PseudoTail.next = newNode
#
#         for i in range(self.size):
#             if self.MinList[i].val > x:
#                 self.MinList.insert(i, newNode)
#                 break
#         else:
#             self.MinList.append(newNode)
#
#         self.size += 1
#
#     def pop(self):
#         """
#         :rtype: void
#         """
#         if self.size > 0:
#             tmp = self.PseudoTail
#             tmp.pre.next = None
#             self.MinList.remove(tmp)
#             self.size -= 1
#
#     def top(self):
#         """
#         :rtype: int
#         """
#         if self.size > 0:
#             tmp = self.PseudoTail
#             return tmp.val
#
#     def getMin(self):
#         """
#         :rtype: int
#         """
#
#         if self.size > 0:
#             tmp = self.MinList.pop(0)
#             tmp.pre.next = tmp.next
#             tmp.next.pre = tmp.pre
#             self.size -= 1
#             return tmp.val
#
#     class DoubleLinkList(object):
#         def __init__(self, x):
#             self.val = x
#             self.pre = None
#             self.next = None

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('inf')



    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(x)
        if self.min > x:
            self.min = x


    def pop(self):
        """
        :rtype: void
        """
        if len(self.stack) > 0:
            self.stack.pop()
            if len(self.stack) > 0:
                self.min = min(self.stack)
            else:
                self.min = float('inf')

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) > 0:
            return self.stack[-1]


    def getMin(self):
        """
        :rtype: int
        """
        if len(self.stack) > 0:
            return self.min

ms = MinStack()
ms.push(1)
ms.push(20)
ms.push(4)
ms.pop()
print(ms.top())
print(ms.getMin())
