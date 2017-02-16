#!/usr/bin/env python2

class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        words = str.split(' ')
        if len(words) != len(pattern):
            return False
        map = {}
        for i in range(len(pattern)):
            c = pattern[i]
            w = words[i]
            if c not in map:
                if w in map.values():
                    return False
                map[c] = w
            elif map[c] != w:
                return False
        return True

