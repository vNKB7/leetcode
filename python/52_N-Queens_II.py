#!/usr/bin/env python3

class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """

        queen = [-1]*n
        return self.helper(0, n, queen)

    def helper(self, layer, n, queen):
        total = 0
        if layer == n:
            return 1

        for i in range(n):
            if self.isVailed(n, layer, queen, i):
                queen[layer] = i
                total += self.helper(layer+1, n, queen)

        return total


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
print(s.totalNQueens(8))