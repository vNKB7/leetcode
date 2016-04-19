#!/usr/bin/env python

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        maxLen = 0
        maxString = ''
        for i in range(len(s)):
            s1, l1 = self.oddPalindrome(s, i)
            s2, l2 = self.evenPalindrome(s, i)
            print(self.oddPalindrome(s, i))
            print(self.evenPalindrome(s, i))
            if l1 > max(l2, maxLen):
                maxLen = l1
                maxString = s1
            elif l2 > max(l1, maxLen):
                maxLen = l2
                maxString = s2

        return maxString


    def oddPalindrome(self, s, index):
        strlen = len(s)
        maxlen = min(index+1, strlen-index)
        count = 0
        for i in range(maxlen):
            if s[index+i] == s[index-i]:
                count += 1
            else:
                break
        return s[index-count+1:index+count], count*2-1

    def evenPalindrome(self, s, index):
        strlen = len(s)
        maxlen = min(index+1, strlen-index-1)
        count = 0
        for i in range(maxlen):
            if s[index+1+i] == s[index-i]:
                count += 1
            else:
                break
        return s[index-count+1:index+count+1],count*2

s = Solution()
print(s.longestPalindrome('1bb'))

