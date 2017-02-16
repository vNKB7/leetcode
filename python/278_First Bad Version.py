#!/usr/bin/env python2

# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
def isBadVersion(version):
    return version >= 57

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        start = 1
        end = n
        v = n
        while start <= end:
            mid = (start + end) / 2
            if isBadVersion(mid):
                end = mid - 1
                if mid < v:
                    v = mid
            else:
                start = mid + 1

        return v

s = Solution()
print s.firstBadVersion(100)