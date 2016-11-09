#!/usr/bin/env python3

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """

        result = 0

        if s is None or s == '':
            return result

        if s[0] == '0':
            return result

        s += '.'

        tmp = [0] * (len(s))
        tmp[-1] = 1
        tmp[-2] = 1

        for i in range(len(tmp)-2)[::-1]:
            if int(s[i]) == 1 or (int(s[i]) == 2 and int(s[i+1]) <= 6):
                if s[i+2] == '0' or s[i+1] == '0':
                    tmp[i] = tmp[i+1]
                else:
                    tmp[i] = tmp[i+1] + tmp[i+2]
            elif s[i+1] == '0':
                return 0
            else:
                tmp[i] = tmp[i+1]

        return tmp[0]

s = Solution()
print(s.numDecodings('20'))


