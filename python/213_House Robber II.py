#!/usr/bin/env python2

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        return max(self.sub_rob(nums[:-1]), self.sub_rob(nums[1:]))


    def sub_rob(self, nums):
        if not nums or len(nums) == 0:
            return 0

        a = b = c = 0

        for num in nums:
            c = max(a + num, b)
            a, b = b, c

        return b