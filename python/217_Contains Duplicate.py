#!/usr/bin/env python2

class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        nums_set = set(nums)
        return len(nums_set) != len(nums)

