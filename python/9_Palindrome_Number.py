#!/usr/bin/env python

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False

        length = 0
        max = 1
        tmp = x
        while tmp > 0:
            tmp //= 10
            length += 1
            max *= 10

        max /= 10
        loop = int(length / 2 if length % 2 == 0 else (length + 1)/2)

        for i in range(loop):
            left = x // max
            right = x % 10
            if left != right:
                return False
            else:
                x %= max
                max /= 100
                x //= 10
        return True

s = Solution()
print(s.isPalindrome(1234321))


