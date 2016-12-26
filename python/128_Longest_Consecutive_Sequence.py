#!/usr/bin/env python3

class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        sortedList = sorted(nums)

        maxLength = 1
        curLength = 1
        last = sortedList[0]
        for num in sortedList[1:]:
            if num - last == 1:
                curLength += 1
                if curLength > maxLength:
                    maxLength = curLength
            elif num == last:
                continue
            else:
                curLength = 1
            last = num

        return maxLength

s = Solution()
print(s.longestConsecutive([1,2,0,1]))

