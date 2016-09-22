#!/usr/bin/env python3

'''
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = 0
        b = 1
        while n > 0:
            tmp = a + b
            a = b
            b = tmp
            n -= 1

        return b
'''

import math
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        return int(1/math.sqrt(5)*(pow((1+math.sqrt(5))/2,n+1)-pow((1-math.sqrt(5))/2,n+1)))

s = Solution()
print(s.climbStairs(5))