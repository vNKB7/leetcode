#!/usr/bin/env python3

class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """

        M = len(dungeon)
        N = len(dungeon[0])
        curList = [0] * N
        preList = [0] * N

        for i in range(M)[::-1]:
            for j in range(N)[::-1]:
                if i == M - 1 and j == N - 1:
                    curList[j] = max(1, 1 - dungeon[i][j])
                elif i == M - 1:
                    curList[j] = max(1, curList[j+1] - dungeon[i][j])
                elif j == N - 1:
                    curList[j] = max(1, preList[j] - dungeon[i][j])
                else:
                    curList[j] = max(1, min(curList[j+1], preList[j]) - dungeon[i][j])
            preList = curList
            curList = [0] * N

        return preList[0]

s = Solution()
print(s.calculateMinimumHP([[-2,-3,3],[-5,-10,1],[10,30,-5]]))