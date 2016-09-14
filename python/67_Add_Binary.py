#!/usr/bin/env python3

class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """

        result = ''

        a = a[::-1]
        b = b[::-1]

        c = 0

        for i in range(max(len(a), len(b))):
            if i < len(a):
                a_i = int(a[i])
            else:
                a_i = 0

            if i < len(b):
                b_i = int(b[i])
            else:
                b_i = 0
            c, mod = divmod(a_i + b_i + c, 2)
            result += str(mod)

        if c > 0:
            result += str(c)

        return result[::-1]

s = Solution()
print(s.addBinary('11', '1'))
