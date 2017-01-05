#!/usr/bin/env python3
import math

# 错的
# class Solution:
#     # @param {integer[]} nums
#     # @return {string}
#     def largestNumber(self, nums):
#         str_list = [str(num) for num in nums]
#         maxLen = max(len(s) for s in str_list)
#
#         for i in range(maxLen)[::-1]:
#             temp = [(int(x[i]) if len(x) > i else int(x[0]) ,x) for x in str_list]
#             str_list = [x[1] for x in self.counting_sort(temp, 10)] # 使用了上面的counting_sort
#
#         return ''.join(str_list[::-1])
#
#     def counting_sort(self, array, k):
#         """
#         :param array: list[int] or list[(int, ...)] unsorted-array
#         :param k: int size of extra space
#         :return: list[int] or list[(int, ...)] sorted-array
#         """
#
#         temp = [0] * k
#         result = [0] * len(array)
#
#         for i in range(len(array)):
#             temp[array[i][0]] += 1
#
#         for i in range(1, k):
#             temp[i] = temp[i] + temp[i-1]
#
#         for i in range(len(array))[::-1]: #倒序遍历以保证稳定
#             result[temp[array[i][0]]-1] = array[i] #这里-1是因为在temp中index最小是1。0是没有的意思，不是index为0的意思
#             temp[array[i][0]] -= 1
#
#         return result

# python 2.7
class Solution:
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, num):
        num = [str(x) for x in num]
        num.sort(cmp=lambda x, y: cmp(y+x, x+y))
        return ''.join(num).lstrip('0') or '0'

s = Solution()
print(s.largestNumber([12,121]))







