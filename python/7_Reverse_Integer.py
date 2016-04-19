#!/usr/bin/env python


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0

        num = abs(x)
        op = True if x >= 0 else False
        if op:
            rt = int(str(num)[::-1])
        else:
            rt = -int(str(num)[::-1])
        
        if rt > 2147483647 or rt < -2147483648:
            return 0
        else:
            return rt

        # res = 0
        # op = True if x >= 0 else False
        # x = abs(x)
        # while x > 0:
        #     res = res * 10 + x % 10
        #     x = x//10
        #
        # if not op:
        #     res = -res
        # if res > 2147483647 or res < -2147483648:
        #     return 0
        # return res


s = Solution()
print(s.reverse(12345))