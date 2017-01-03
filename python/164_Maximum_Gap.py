#!/usr/bin/env python3
import math

# 本机运行正确，在leetcode上运行不正确。可能是python版本问题
#


class ListNode(object):
        def __init__(self, val):
            self.val = val
            self.next = None

class Solution(object):
    def bucket_sort(self, array):
        """
        :param array: list[float] or list[(float, ...)] unsorted-array
        :return: list[float] or list[(float, ...)] sorted-array
        """
        n = len(array)
        linkArray = [ListNode(-1) for i in range(n)]
        result = []

        if isinstance(array[0], int): #根据是否附带卫星数据分情况
            for i in range(n):
                index = math.floor(n * array[i])
                newNode = ListNode(array[i])
                cur = linkArray[index]
                while cur.next:
                    if cur.next.val >= array[i]:
                        newNode.next = cur.next
                        cur.next = newNode
                        break
                    cur = cur.next
                else:
                    cur.next = newNode

            for i in range(len(linkArray)):
                if linkArray[i].next:
                    cur = linkArray[i].next
                    while cur:
                        result.append(cur.val)
                        cur = cur.next
        else:
            for i in range(n):
                index = int(math.floor(n * array[i][0]))
                newNode = ListNode(array[i])
                cur = linkArray[index]
                while cur.next:
                    if cur.next.val[0] >= array[i][0]:
                        newNode.next = cur.next
                        cur.next = newNode
                        break
                    cur = cur.next
                else:
                    cur.next = newNode

            for i in range(len(linkArray)):
                if linkArray[i].next:
                    cur = linkArray[i].next
                    while cur:
                        result.append(cur.val)
                        cur = cur.next

        return result

    def bucket_sort_pretreatment(self, array):
        new_array = []

        if isinstance(array[0], int):
            maxNum = max(array)
            minNum = min(array)
            length = maxNum - minNum + 1
            new_array = [((x-minNum)/length, x) for x in array]
        else:
            maxNum = max([x[0] for x in array])
            minNum = min([x[0] for x in array])
            length = maxNum - minNum + 1
            new_array = [((x[0]-minNum)/length, x) for x in array]

        return new_array

    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) < 2:
            return 0

        result = [x[1] for x in self.bucket_sort(self.bucket_sort_pretreatment(nums))]
        gap = 0
        for i in range(1, len(result)):
            if result[i] - result[i-1] > gap:
                gap = result[i] - result[i-1]

        return gap

s = Solution()
print(s.maximumGap([1,10000000]))
