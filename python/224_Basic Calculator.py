#!/usr/bin/env python2

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        num = 0
        result = 0
        sign = True
        stack = []

        for c in s:
            if c == ' ':
                continue
            elif 0 <= ord(c) - ord('0') <= 9:
                num = num * 10 + int(c)
            else:
                result = result + num if sign else result - num
                num = 0
                if c == '+':
                    sign = True
                elif c == '-':
                    sign = False
                elif c == '(':
                    stack.append((result, sign))
                    result = 0
                    sign = True
                elif c == ')':
                    result_t, sign_t = stack.pop(-1)
                    result = result_t + result if sign_t else result_t - result
        return result + num if sign else result - num

s = Solution()
print s.calculate("(1)")

