#!/usr/bin/env python2

class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) < 2:
            return s

        mid = (len(s)-1) // 2
        for i in range(mid+1)[::-1]:
            if s[:i+1] == s[i+1:2*i+3][::-1]:
                return s[i+1:][::-1] + s[i+1:]
            if s[:i] == s[i+1:2*i+1][::-1]:
                return s[i+1:][::-1] + s[i:]


'''
class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) < 2:
            return s

        mid = (len(s)-1) // 2
        for i in range(mid, -1, -1):
            for j in range(-1,i):
                if s[i-j] != s[i+j+1]:
                    break
            else:
                return s[i+1:][::-1] + s[i+1:]
            for j in range(1, i):
                flag = True
                if s[i-j] != s[i+j]:
                    break
            else:
                return s[i+1:][::-1] + s[i:]
'''

s = Solution()
print(s.shortestPalindrome('bca'))
