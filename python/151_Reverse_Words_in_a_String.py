#!/usr/bin/env python3
import re

class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """

        slices = re.split('\s+', s.strip())
        slices.reverse()
        return ' '.join(slices)


