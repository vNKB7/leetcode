#!/usr/bin/env python3
import math

class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """

        k -= 1

        result = ''
        remain = [int(x) for x in range(1, n+1)]

        all = math.factorial(n)

        if k > all:
            return

        while n > 0:
            all /= n
            div, k = divmod(k, all)
            result += str(remain.pop(int(math.floor(div))))

            n -= 1
        return result

s = Solution()
print(s.getPermutation(3,1))