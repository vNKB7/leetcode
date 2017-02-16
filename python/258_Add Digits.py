#!/usr/bin/env python2

class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num > 9:
            str_num = str(num)
            num = 0
            for c in str_num:
                num += ord(c) - ord('0')

        return num