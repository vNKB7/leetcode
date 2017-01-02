#!/usr/bin/env python3


'''
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nums.insert(0, float('-inf'))
        nums.append(float('-inf'))

        for i in range(1, len(nums)-1):
            if nums[i-1] < nums[i] > nums[i+1]:
                return i-1
'''

# use binary search
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.insert(0, float('-inf'))
        nums.append(float('-inf'))

        left = 1
        right = len(nums) - 1

        while left < right:
            if right - left == 1:
                if nums[left-1] < nums[left] > nums[left+1]:
                    return left - 1
                else:
                    return -1

            mid = (left + right) // 2
            if nums[mid-1] < nums[mid] > nums[mid+1]:
                return mid - 1
            elif nums[mid-1] < nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                right = mid

        return -1
