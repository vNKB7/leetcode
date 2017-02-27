#!/usr/bin/env python2

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        sum = (0 + len(nums)) * (len(nums)+1) / 2
        for n in nums:
            sum -= n

        return sum