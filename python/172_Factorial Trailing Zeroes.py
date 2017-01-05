#!/usr/bin/env python3

class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 5:
            return 0

        count_5 = 0
        i = 5
        while i <= n:
            count_5 += n // i
            i *= 5
        return count_5

s = Solution()
print(s.trailingZeroes(25))

