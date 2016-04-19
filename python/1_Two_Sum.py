#!/usr/bin/env python

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]


        #只适用于正整数。不能通过测试。
        # array = [-1 for i in range(target+1)]
        # for i in range(len(nums)):
        #     index = target-nums[i]
        #     if 0 <= index < len(array):
        #         if array[index] != -1:
        #             return [i, array[index]]
        #         elif array[nums[i]] == -1:
        #             array[nums[i]] = i


s = Solution()
print(s.twoSum([3,2,4],6))