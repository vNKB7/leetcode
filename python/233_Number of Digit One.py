#!/usr/bin/env python2

class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """

        count = 0
        numCount = []
        while n != 0:
            n, m = divmod(n, 10)
            numCount.append(m)

        for i, base in enumerate(numCount):
            if base > 0:
                count += 10 ** i
                count += (base-1) * (100 ** i - sum([10**x for x in range(i)]))


s = Solution()
print s.countDigitOne(1234350)

