#!/usr/bin/env python3

class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """

        if s is None or len(s) == '':
            return 0

        words = s.strip().split(' ')

        if len(words) == 0:
            return 0

        return len(words[-1])