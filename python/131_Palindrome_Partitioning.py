#!/usr/bin/env python3

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """

        return self.helper(s, [])


    def helper(self, str, pre):
        if len(str) == 1:
            pre.append(str)
            return [pre]
        elif len(str) == 0:
            return [pre]

        result = []
        for i in range(1, len(str)+1):
            if self.isPalindrome(str[:i]):
                newPre = pre[:]
                newPre.append(str[:i])
                result.extend(self.helper(str[i:], newPre))

        return result
    def isPalindrome(self, str):
        return str == str[::-1]