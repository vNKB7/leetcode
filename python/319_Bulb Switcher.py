#!/usr/bin/env python2
#coding=utf8

import math
class Solution(object):
    def bulbSwitch(self, n):
        """
        :type n: int
        :rtype: int
        """
        return int(math.sqrt(n))

s = Solution()
print s.bulbSwitch(3)