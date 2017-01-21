#!/usr/bin/env python2

class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        return self.helper(k, n, 9)

    def helper(self, k, n, bound):
        if k == 1:
            if 0 < n <= bound:
                return [[n]]
            else:
                return None

        result = []
        for i in range(1, min(n, bound)+1)[::-1]:
            r = self.helper(k-1, n-i, i-1)
            if r:
                for j in range(len(r)):
                    r[j].append(i)
                result.extend(r)

        return result

s = Solution()
print s.combinationSum3(3,9)