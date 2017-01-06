#!/usr/bin/env python3

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """

        count = 0

        while n > 0:
            count += n & 1
            n >>= 1

        return count

s = Solution()
print(s.hammingWeight(11))