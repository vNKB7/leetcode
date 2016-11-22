#!/usr/bin/env python3

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0

        dep = len(triangle)
        result = [0] * dep

        for i in range(dep):
            for j in range(dep-i-1, dep):
                if j == dep-i-1:
                    result[j] = (result[j+1] if j+1 < dep else 0) + triangle[i][0]
                else:
                    result[j] = triangle[i][j-dep+i+1] + (min(result[j], result[j+1]) if j+1 < dep else result[j])

        return min(result)

s = Solution()
print(s.minimumTotal([[1],[1,2],[1,2,3],[1,2,3,4]]))




