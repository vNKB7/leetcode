#!/usr/bin/env python2

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        char = [0] * 26
        for c in s:
            char[ord(c)-ord('a')] += 1

        for c in t:
            char[ord(c)-ord('a')] -= 1

        return len([x for x in char if x == 0]) == 26

