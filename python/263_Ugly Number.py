#!/usr/bin/env python2
'''
class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 1:
            return False

        while num % 2 == 0:
            num /= 2

        while num % 3 == 0:
            num /= 3

        while num % 5 == 0:
            num /= 5

        return num == 1
'''
class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """

        for p in 2, 3, 5:
            while num % p == 0 < num: # 有点谐，为了不让num取0
                num /= p
        return num == 1

s = Solution()
print s.isUgly(5)