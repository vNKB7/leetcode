#!/usr/bin/env python2

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return 0

        subLen = [nums[0]]
        maxLen = 1

        for i in range(1, len(nums)):
            for j in range(maxLen):
                if nums[i] <= subLen[j]:
                    subLen[j] = nums[i]
                    break
            else:
                subLen.append(nums[i])
                maxLen += 1
        return maxLen

s = Solution()
print s.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18])


