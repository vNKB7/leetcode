#!/usr/bin/env python3

class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        curRow = [1]

        for i in range(rowIndex+1):
            for j in range(i-1):
                curRow[j] = curRow[j] + curRow[j+1]

            if i > 0:
                curRow.insert(0, 1)

        return curRow

s = Solution()
print(s.getRow(2))