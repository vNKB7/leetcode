#!/usr/bin/env python3

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        result = []

        div = 1
        for n in digits[::-1]:
            div, mod = divmod(n+div, 10)
            result.append(mod)

        if div == 1:
           result.append(1)
        result.reverse()
        return result

s = Solution()
print(s.plusOne([9,9,9]))