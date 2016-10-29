#!/usr/bin/env python3

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """

        begin = end = 0
        #windowBegin = windowEnd = 0
        #minWindowBegin = minWindowEnd = 0
        curLen = 0

        minLength = 100000
        minSubStr = ''

        hasFound = {}
        needToFind = {}

        for c in t:
            if c in needToFind:
                needToFind[c] += 1
            else:
                needToFind[c] = 1
                hasFound[c] = 0

        while end < len(s):
            if s[end] in needToFind:
                hasFound[s[end]] += 1
            else:
                end += 1
                continue

            if hasFound[s[end]] <= needToFind[s[end]]:
                curLen += 1

            if curLen >= len(t):
                while s[begin] not in needToFind or hasFound[s[begin]] > needToFind[s[begin]]:
                    if s[begin] in needToFind:
                        hasFound[s[begin]] -= 1
                    begin += 1


                if end - begin + 1 < minLength:
                    minLength = end - begin + 1
                    minSubStr = s[begin:end+1]

            end += 1

        return minSubStr

s = Solution()
print(s.minWindow('ADOBECODEBANC', 'ABC'))
