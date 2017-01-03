#!/usr/bin/env python3
import math

class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        sign = 1
        if numerator < 0 and denominator < 0:
            numerator = -numerator
            denominator = -denominator
        elif numerator > 0 and denominator < 0:
            sign = -1
            denominator = -denominator
        elif numerator < 0 and denominator > 0:
            sign = -1
            numerator = -numerator

        integer_part = int(math.floor(numerator / denominator))
        remain = numerator % denominator
        if remain == 0:
            return ('-' if sign == -1 else '') +str(integer_part)

        result = []
        remain_list = []

        while remain > 0:
            remain_list.append(remain)
            remain *= 10
            high = int(math.floor(remain / denominator))
            remain = remain % denominator
            result.append(str(high))
            if high != 0 and remain in remain_list:
                result.insert(remain_list.index(remain), '(')
                result.append(')')
                break


        return ('-' if sign == -1 else '') + str(integer_part)+'.'+''.join(result)

s = Solution()
print(s.fractionToDecimal(-50,8))