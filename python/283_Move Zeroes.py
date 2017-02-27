#!/usr/bin/env python2

class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        slow = fast = 0
        while slow < len(nums):
            if nums[slow] == 0:
                break
            slow += 1
        fast = slow
        while fast < len(nums):
            if nums[fast] == 0:
                fast += 1
            elif nums[slow] != 0:
                slow += 1
            else:
                nums[slow] = nums[fast]
                nums[fast] = 0
                slow += 1
                fast += 1

nums = [1,0,2,0,3,4,0,0,5]
s = Solution()
s.moveZeroes(nums)
print nums