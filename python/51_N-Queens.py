#!/usr/bin/env python3

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = []
        queen = [-1]*n
        self.helper(result, 0, n, queen)
        return result

    def helper(self, result, layer, n, queen):
        if layer == n:
            strList = []
            for i in queen:
                str = ""
                for j in range(n):
                    if i == j:
                        str += "Q"
                    else:
                        str += "."
                strList.append(str)
            result.append(strList)

        for i in range(n):
            if self.isVailed(n, layer, queen, i):
                queen[layer] = i
                self.helper(result, layer+1, n, queen)


    def isVailed(self, n, layer, queen, pos):
        for i in range(layer):
            if queen[i] == pos:
                return False

        for i in range(layer):
            j = queen[i]
            if layer - i == pos - j:
                return False

            if layer - i + pos == j:
                return False
        return True

s = Solution()
s.solveNQueens(8)