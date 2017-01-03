#!/usr/bin/env python3

class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """

        result = ''

        while n > 0:
            d = (n-1) % 26
            n = (n-1) // 26
            result += chr(ord('A') + d)

        return result[::-1]


s = Solution()
print(s.convertToTitle(52))