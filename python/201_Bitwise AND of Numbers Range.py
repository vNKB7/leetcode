#!/usr/bin/env python
import math

class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """

        if m == 0:
            return 0

        log_m = int(math.log(m,2)) + 1
        log_n = int(math.log(n,2)) + 1

        if log_m < log_n:
            return 0

        result = 1

        b = log_m
        m %= 2 ** (b-1)
        n %= 2 ** (b-1)
        b -= 1
        while b > 0:
            base = 2 ** (b-1)
            if m // base == 0 and n // base == 1 or m == 0:
                while b > 0:
                    result = result * 2
                    b -= 1
                break
            elif m // base == 0 and n // base == 0:
                result = result * 2
            else:
                result = result * 2 + 1
            m %= base
            n %= base
            b -= 1

        return result

s = Solution()
print(s.rangeBitwiseAnd(2147483646,2147483647))



