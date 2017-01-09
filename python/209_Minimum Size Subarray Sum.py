#!/usr/bin/env python

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """

        global_min = float('inf')

        start = 0
        end = 0
        sum = 0
        while end < len(nums):
            sum += nums[end]
            end += 1

            while sum >= s:
                if global_min > end - start:
                    global_min = end - start
                sum -= nums[start]
                start += 1

        if global_min == float('inf'):
            return 0
        else:
            return global_min

s = Solution()
print(s.minSubArrayLen(7, [7,3,1,2,4,3]))


