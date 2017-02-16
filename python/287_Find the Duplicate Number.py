#!/usr/bin/env python2

class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        start = min(nums)
        end = max(nums)

        while start <= end:
            mid = (start + end) / 2

            sum = 0
            count = 0
            for n in nums:
                if start <= n <= end:
                    sum += n
                    count += 1

            average = float(sum) / count
            if average == mid:
                return mid
            elif average < mid:
                end = mid - 1
            else:
                start = mid + 1

s = Solution()
print s.findDuplicate([0,1,2,4,4,4,5])