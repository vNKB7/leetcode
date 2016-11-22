#!/usr/bin/env python3

class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        result = []

        for i in range(numRows):
            curRow = [1]

            for j in range(1, i):
                curRow.append(result[i-1][j-1] + result[i-1][j])

            if i > 0:
                curRow.append(1)

            result.append(curRow)
        return result

s = Solution()
print(s.generate(6))