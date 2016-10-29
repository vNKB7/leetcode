#!/usr/bin/env python3

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        return self.helper(1, n, k)


    def helper(self, begin, end, depth):
        if depth == 0:
            return []

        result = []
        while end - begin + 1 >= depth:
            if depth - 1 == 0:
                subList = [[begin]]
            else:
                subList = self.helper(begin+1, end, depth-1)
                subList = [[begin] + x for x in subList]
            result.extend(subList)
            begin += 1

        return result

s = Solution()
print(s.combine(4,2))