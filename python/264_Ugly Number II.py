#!/usr/bin/env python2

class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """

        k = [1] * n
        t2 = t3 = t5 = 0
        index = 0
        while index < n - 1:
            index += 1
            k[index] = min(k[t2]*2, k[t3]*3, k[t5]*5)
            if k[index] == k[t2]*2:
                t2 += 1
            if k[index] == k[t3]*3:
                t3 += 1
            if k[index] == k[t5]*5:
                t5 += 1
        return k[-1]


s = Solution()
print s.nthUglyNumber(7)