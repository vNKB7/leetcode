#!/usr/bin/env python3

#动态规划
class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """

        if not s or not t or not len(s) or not len(t):
            return 0

        m = len(s)
        n = len(t)

        lastLine = [0] * m
        curLine = [0] * m

        startPoint = 0

        for i in range(n):
            lastLine = curLine
            curLine = [0] * m
            curSP = m
            for j in range(m):
                if t[i] == s[j]:
                    if curSP > j:
                        curSP = j
                    count = 0
                    if i > 0 and j > 0:
                        for k in range(startPoint, j):
                            count += lastLine[k]
                    elif i == 0:
                        count = 1
                    curLine[j] = count
            startPoint = curSP

        result = 0
        for n in curLine:
            result += n
        return result

s = Solution()
print(s.numDistinct('rabbbbit', 'rabbit'))








