#!/usr/bin/env python3

'''
1.swap for 3 times
2.loop
3.copy
'''


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        self.swap(nums, 0, len(nums) - k - 1)
        self.swap(nums, len(nums) - k, len(nums) - 1)
        self.swap(nums, 0, len(nums) - 1)

    def swap(self, nums, start, end):
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1

s = Solution()
nums = [1,2,3,4,5,6]
s.rotate(nums, 11)
print(nums)
