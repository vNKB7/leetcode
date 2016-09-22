#!/usr/bin/env python3

#extra space of O(m+n)
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return

        row = [0]*len(matrix)
        col = [0]*len(matrix[0])

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    row[i] = 1
                    col[j] = 1

        for i in range(len(row)):
            if row[i] == 1:
                for j in range(len(matrix[0])):
                    matrix[i][j] = 0

        for j in range(len(col)):
            if col[j] == 1:
                for i in range(len(matrix)):
                    matrix[i][j] = 0


s = Solution()
matrix = [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
s.setZeroes(matrix)
print(matrix)