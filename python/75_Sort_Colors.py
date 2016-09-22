#!/usr/bin/env python3
'''
#two pass algorithm
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        zero = 0
        one = 0
        two = 0

        for num in nums:
            if num == 0:
                zero += 1
            elif num == 1:
                one += 1
            else:
                two += 1

        for i in range(zero):
            nums[i] = 0
        for i in range(zero, zero + one):
            nums[i] = 1
        for i in range(zero + one, zero + one + two):
            nums[i] = 2
'''

#one pass algorithm
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        zeroPoint = 0
        twoPoint = onePoint = len(nums)

        while zeroPoint < onePoint:
            if nums[zeroPoint] == 0:
                zeroPoint += 1
            elif nums[zeroPoint] == 1:
                onePoint -= 1
                nums[zeroPoint], nums[onePoint] = nums[onePoint] ,nums[zeroPoint]
            else:
                onePoint -= 1
                twoPoint -= 1
                nums[zeroPoint], nums[onePoint], nums[twoPoint] = nums[onePoint], nums[twoPoint], nums[zeroPoint]

s = Solution()
nums = [0,1,2,2,1,1]
s.sortColors(nums)
print(nums)