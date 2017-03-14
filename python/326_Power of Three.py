#!/usr/bin/env python2
#coding=utf8
'''
class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 1:
            return False
        while n > 1:
            if n % 3 != 0:
                return False
            n /= 3
        return True
'''

class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 1:
            return False
        base = 3
        while n > 1:
            if n % base != 0:
                if base == 3:
                    return False
                else:
                    base /= 3
            else:
                n /= base
                base *= 3
        return True

'''
return n>0 && 1162261467%n==0
'''


s = Solution()
print s.isPowerOfThree(81)