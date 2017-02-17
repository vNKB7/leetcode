#!/usr/bin/env python2

class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        if not num or len(num) == 0:
            return False

        if len(num) < 3:
            return False

        for i in range(len(num) / 2 + 1):
            for j in range(i+1, len(num)-1):
                if i > 0 and num[0] == '0':
                    return False
                if j - i > 1 and num[i+1] == '0':
                    continue
                num1 = int(num[:i+1])
                num2 = int(num[i+1:j+1])
                if self.helper(num1, num2, num[j+1:]):
                    return True
        return False

    def helper(self, num1, num2, remain):
        if len(remain) == 0:
            return True
        sum = str(num1 + num2)
        if len(sum) > len(remain):
            return False
        if sum != remain[:len(sum)]:
            return False
        else:
            return self.helper(num2, num1 + num2, remain[len(sum):])

s = Solution()
print s.isAdditiveNumber('198019823962')