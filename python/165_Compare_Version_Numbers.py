#!/usr/bin/env python3

class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """

        if not version1 or not version2 or len(version1) <= 0 or len(version2) <= 0:
            return 0

        v1 = version1.split('.')
        v2 = version2.split('.')

        minLength = len(v1) if len(v1) < len(v2) else len(v2)

        i = 0
        while i < minLength:
            if int(v1[i]) < int(v2[i]):
                return -1
            elif int(v1[i]) > int(v2[i]):
                return 1
            i += 1

        if len(v1) > i:
            while i < len(v1):
                if int(v1[i]) != 0:
                    return 1
                i += 1
        elif len(v2) > i:
            while i < len(v2):
                if int(v2[i]) != 0:
                    return -1
                i += 1

        return 0

s = Solution()
print(s.compareVersion('1.2333', '1.233.2'))