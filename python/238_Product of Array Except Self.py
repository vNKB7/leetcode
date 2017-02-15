#!/usr/bin/env python2

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        hasZero = 0
        mul = 1
        for num in nums:
            if num != 0:
                mul *= num
            else:
                hasZero += 1

        if hasZero > 1:
            for i in range(len(nums)):
                nums[i] = 0
        elif hasZero == 1:
            for i in range(len(nums)):
                if nums[i] == 0:
                    nums[i] = mul
                else:
                    nums[i] = 0
        else:
            for i in range(len(nums)):
                nums[i] = mul/nums[i]
        return nums
