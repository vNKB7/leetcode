#!/usr/bin/env python3

'''
#Newton's method
import math

class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0

        k = 1.0

        while math.fabs(k * k - x) > 0.1:
            k = (k + x / k) / 2

        return math.floor(k)
'''

class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        start = 0
        end = x

        while start <= end:
            k = (end + start) // 2
            if k * k <= x < (k+1)*(k+1):
                return k
            elif k * k > x:
                end = k - 1
            else:
                start = k + 1
        return k


s = Solution()
print(s.mySqrt(1))