#!/usr/bin/env python3

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return 0

        a = b = c = 0

        for num in nums:
            c = max(a + num, b)
            a, b = b, c

        return b




