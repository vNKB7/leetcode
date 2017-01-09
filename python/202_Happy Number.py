#!/usr/bin/env python

class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """

        visit = set()
        while n != 1:
            if n in visit:
                return False
            else:
                visit.add(n)
                new_n = 0
                while n != 0:
                    new_n += (n % 10) ** 2
                    n /= 10
                n = new_n

        return True

s = Solution()
print(s.isHappy(7))