#!/usr/bin/env python2


class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """

        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return
        m, n = len(matrix), len(matrix[0])
        self.store = [[0] * n for _ in range(m+1)]

        for i in range(m):
            temp = [0] * (n+1)
            for j in range(n):
                temp[j+1] = temp[j] + matrix[i][j]
                self.store[i+1][j] = self.store[i][j] + temp[j+1]

        self.store.pop(0)


    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.store[row2][col2] - (self.store[row2][col1-1] if col1 > 0 else 0) - (self.store[row1-1][col2] if row1 > 0 else 0) + (self.store[row1-1][col1-1] if row1 > 0 and col1 > 0 else 0)



# Your NumMatrix object will be instantiated and called as such:
matrix = [[1], [-7]]
obj = NumMatrix(matrix)
print obj.sumRegion(1,0,1,0)