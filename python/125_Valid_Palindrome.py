#!/usr/bin/env python3

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        newString = [c for c in s if c.isalpha() or c.isnumeric()]
        length = len(newString) // 2
        for i in range(length):
            if newString[i] != newString[-i-1]:
                return False
        return True

s = Solution()
print(s.isPalindrome("0P"))

