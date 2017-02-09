#!/usr/bin/env python2

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or len(matrix) == 0 or not matrix[0] or len(matrix[0]) == 0:
            return 0

        max_edge = 0

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '1':
                    start = max_edge
                    end = min(len(matrix)-i-1, len(matrix[0])-j-1)
                    if start > end:
                        continue
                    max_edge = max(1, max_edge, self.find_max_edge(matrix, i, j, start, end))

        return max_edge * max_edge

    def find_max_edge(self, matrix, i, j, start, end):
        for x in range(i, i+start+1):
            for y in range(j, j+start+1):
                if matrix[x][y] != '1':
                    return -1

        for c in range(start+1, end+1):
            for x in range(i,i+c):
                if matrix[x][j+c] != '1':
                    return c
            for y in range(j, j+c):
                if matrix[i+c][y] != '1':
                    return c
            if matrix[i+c][j+c] != '1':
                return c

        return end

s = Solution()
print s.maximalSquare(["10100","10111","11111","10111"])