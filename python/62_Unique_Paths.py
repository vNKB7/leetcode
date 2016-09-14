#!/usr/bin/env python3

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """

        col = [0] * n
        col[-1] = 1

        for i in range(m)[::-1]:
            for j in range(n)[::-1]:
                if j != n-1:
                    col[j] += col[j+1]

        return col[0]

s = Solution()
print(s.uniquePaths(3,3))

