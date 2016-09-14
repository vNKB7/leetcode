#!/usr/bin/env python3

class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        if grid is None or len(grid) == 0:
            return 0
        if grid[0] is None or len(grid[0]) == 0:
            return 0

        m = len(grid)
        n = len(grid[0])

        col = [0] * n

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    col[j] = grid[i][j]
                elif i == 0 and j != 0:
                    col[j] = col[j-1] + grid[0][j]
                elif i != 0 and j == 0:
                    col[j] += grid[i][0]
                else:
                    col[j] = min(col[j], col[j-1]) + grid[i][j]

        return col[n-1]


s = Solution()
print(s.minPathSum([
  [1,0,0],
  [0,1,0],
  [0,0,1]
]))
