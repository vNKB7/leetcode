#!/usr/bin/env python2

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """

        length = len(citations)
        array = [0] * (length+1)
        for c in citations:
            if c > length:
                array[length] += 1
            else:
                array[c] += 1

        sum = 0
        for i in range(length, -1, -1):
            sum += array[i]
            if sum >= i:
                return i

s = Solution()
print s.hIndex([3, 0, 6, 1, 5])