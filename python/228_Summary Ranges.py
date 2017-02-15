#!/usr/bin/env python2

class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """

        if not nums or len(nums) == 0:
            return []

        nums.append('0')
        start = last = nums[0]
        result = []
        for num in nums[1:]:
            if last + 1 == num:
                last = num
            else:
                if start == last:
                    result.append('%d' % start)
                else:
                    result.append('%d->%d' % (start, last))
                start = last = num
        return result

s = Solution()
print s.summaryRanges([0,1,2,4,5,7])