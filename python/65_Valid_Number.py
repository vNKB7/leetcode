#!/usr/bin/env python3

class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """

        if s is None or len(s) == 0:
            return False

        s = s.strip()
        s = s.lower()

        if 'e' in s:
            slice = s.split('e')
            if len(slice) > 2:
                return False
            return self.getType(slice[0]) != -1 and self.getType(slice[1]) == 1

        else:
            return self.getType(s) != -1


    def getType(self, s):
        if s == '':
            return -1

        if '.' in s:
            slice = s.split('.')
            if slice[0] == '' and slice[1] == '':
                return -1

            if len(slice) > 2:
                return -1
            if slice[0] != '' and (slice[0][0] == '+' or slice[0][0] == '-'):
                slice[0] = slice[0][1:]

            if (slice[0] == '' or slice[0].isdigit()) and (slice[1] == '' or slice[1].isdigit()):
                return 2
            else:
                return -1

        else:
            if s[0] == '+' or s[0] == '-':
                s = s[1:]
            if s.isdigit():
                return 1
            else:
                return -1


s = Solution()
print(s.isNumber("e"))

#太繁琐了，没有意义