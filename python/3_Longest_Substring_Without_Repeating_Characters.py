#!/usr/bin/env python

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        myDict = dict()
        count = continueCount = breakindex = 0

        for i in range(len(s)):
            if s[i] in myDict:
                count = max(count, continueCount)
                breakindex = max(myDict[s[i]], breakindex)
                continueCount = i - breakindex

            else:
                continueCount += 1
            myDict[s[i]] = i


        return max(count, continueCount)



s = Solution()
print(s.lengthOfLongestSubstring("qufmtrybowpuqogwczuqxisjyryjpyxiucuovu"))

