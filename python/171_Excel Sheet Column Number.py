#!/usr/bin/env python3

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """

        sum = 0

        for i in range(len(s)):
            num = ord(s[i]) - ord('A') + 1
            sum = sum * 26 + num
        return sum

s = Solution()
print(s.titleToNumber('A'))