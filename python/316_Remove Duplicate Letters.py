#!/usr/bin/env python2
#coding=utf8

class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """

        count = [s.count(chr(ord('a') + i)) for i in range(26)]
        pos = 0
        for i in range(len(s)):
            if s[i] < s[pos]:
                pos = i
            count[ord(s[i]) - ord('a')] -= 1
            if count[ord(s[i]) - ord('a')] == 0:
                break
        return s[pos] + self.removeDuplicateLetters(s[pos+1:].replace(s[pos], '')) if s else ''



s = Solution()
print s.removeDuplicateLetters('bcabc')