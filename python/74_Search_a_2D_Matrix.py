#!/usr/bin/env python3
'''
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return False

        for i in range(len(matrix)):
            if target <= matrix[i][-1]:
                if target < matrix[i][0]:
                    return False
                for num in matrix[i]:
                    if num == target:
                        return True
                return False

        return False
'''

#binary search
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return False

        if target < matrix[0][0] or target > matrix[-1][-1]:
            return False

        left = 0
        right = len(matrix) * len(matrix[0])
        rowLen = len(matrix[0])

        while left <= right:
            mid = int((left + right) / 2)
            i, j = divmod(mid, rowLen)
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False



s = Solution()
print(s.searchMatrix([
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
], 22))