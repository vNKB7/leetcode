#!/usr/bin/env python2

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """

        if not board or len(board) == 0 or len(board[0]) == 0:
            return

        m = len(board)
        n = len(board[0])

        next = [[0] * n for _ in range(m) ]

        for i in range(m):
            for j in range(n):
                live = 0
                check_list = [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]
                for x,y in check_list:
                    if 0 <= x <= m - 1 and 0 <= y <= n - 1:
                        if board[x][y] == 1:
                            live += 1
                if board[i][j] == 1 and (live < 2 or live > 3):
                    next[i][j] = 0
                elif board[i][j] == 0 and live == 3:
                    next[i][j] = 1
                else:
                    next[i][j] = board[i][j]

        for i in range(m):
            for j in range(n):
                board[i][j] = next[i][j]

grid = [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]]
s = Solution()
s.gameOfLife(grid)
print grid


