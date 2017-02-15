#!/usr/bin/env python2

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums or len(nums) == 0:
            return []
        if len(nums) == 1:
            return [nums[0]]

        number1 = 0
        number2 = 1
        count1 = 0
        count2 = 0

        for num in nums:
            if num == number1:
                count1 += 1
            elif num == number2:
                count2 += 1
            elif count1 == 0:
                number1 = num
                count1 = 1
            elif count2 == 0:
                number2 = num
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1

        return [x for x in (number1, number2) if nums.count(x) > len(nums) / 3]


