#!/usr/bin/env python3

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        result = 1

        primary = x
        result = 1

        div = abs(n)
        while div != 0:
            div, mod = divmod(div, 2)
            if mod != 0:
                result *= primary
            if 0 < result < 0.000001:
                return 0
            primary = primary * primary

        if n < 0:
            result = 1/result

        return result





s = Solution()
print(s.myPow(2,6))

