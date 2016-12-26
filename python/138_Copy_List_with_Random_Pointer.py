#!/usr/bin/env python3

# Definition for singly-linked list with a random pointer.
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

#用字典保存节点的对应 时间复杂度，如果字典插入和查找记为O(1), 时间复杂度为O(n), 空间复杂度为O(n)
#An intuitive solution is to keep a hash table for each node in the list, via which we just need to iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers. As a result, the space complexity of this solution is O(N), although with a linear time complexity.
#haha, this's it
#
# class Solution(object):
#     def copyRandomList(self, head):
#         """
#         :type head: RandomListNode
#         :rtype: RandomListNode
#         """
#         if not head:
#             return None
#
#         NodeDict = {}
#
#         copyHead = RandomListNode(head.label)
#         NodeDict[head] = copyHead
#
#         src = head
#         dest = copyHead
#         while src.next:
#             dest.next = RandomListNode(src.next.label)
#             NodeDict[src.next] = dest.next
#             src = src.next
#             dest = dest.next
#
#         src = head
#         dest = copyHead
#         while src:
#             if src.random:
#                 dest.random = NodeDict[src.random]
#             dest = dest.next
#             src = src.next
#
#         return copyHead


#通过特殊的链表操作可以达成额外空间复杂度O(1)
class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """








a = RandomListNode(1)
b = RandomListNode(2)
c = RandomListNode(3)
d = RandomListNode(4)
a.next = b
b.next = c
c.next = d
d.next = None
a.random = c
b.random = None
c.random = a
d.random = c

s = Solution()
newList = s.copyRandomList(a)
while newList:
    print(newList.label , newList.next.label if newList.next else None, newList.random.label if newList.random else None)
    newList = newList.next