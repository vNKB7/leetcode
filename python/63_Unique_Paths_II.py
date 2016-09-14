#!/usr/bin/env python3

class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """

        if obstacleGrid is None or len(obstacleGrid) == 0:
            return 0
        if obstacleGrid[0] is None or len(obstacleGrid[0]) == 0:
            return 0

        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        col = [0] * n
        col[-1] = 1

        for i in range(m)[::-1]:
            for j in range(n)[::-1]:
                if obstacleGrid[i][j] == 1:
                    col[j] = 0
                elif j != n-1:
                    col[j] += col[j+1]

        return col[0]

s = Solution()
print(s.uniquePathsWithObstacles([
  [0,0,0],
  [0,1,0],
  [0,0,0]
]))