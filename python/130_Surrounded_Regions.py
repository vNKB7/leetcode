#!/usr/bin/env python3

class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """

        if not board or len(board) == 0:
            return

        m = len(board)
        n = len(board[0])

        surrive = set()
        queue = []

        for i in range(m):
            if board[i][0] == 'O':
                surrive.add((i, 0))
                queue.append((i, 0))
            if board[i][n-1] == 'O':
                surrive.add((i, n-1))
                queue.append((i, n-1))

        for j in range(n):
            if board[0][j] == 'O':
                surrive.add((0, j))
                queue.append((0, j))
            if board[m-1][j] == 'O':
                surrive.add((m-1, j))
                queue.append((m-1, j))

        while len(queue) > 0:
            newQueue = []
            while len(queue) > 0:
                (x, y) = queue.pop(0)
                if x > 0 and board[x-1][y] == 'O':
                    if (x-1, y) not in surrive:
                        surrive.add((x-1, y))
                        newQueue.append((x-1, y))
                if x < m-1 and board[x+1][y] == 'O':
                    if (x+1, y) not in surrive:
                        surrive.add((x+1, y))
                        newQueue.append((x+1, y))
                if y > 0 and board[x][y-1] == 'O':
                    if (x, y-1) not in surrive:
                        surrive.add((x, y-1))
                        newQueue.append((x, y-1))
                if y < n-1 and board[x][y+1] == 'O':
                    if (x, y+1) not in surrive:
                        surrive.add((x, y+1))
                        newQueue.append((x, y+1))
            queue = newQueue

        for i in range(m):
            newStr = ''
            for j in range(n):
                if board[i][j] == 'O' and (i, j) in surrive:
                    newStr += 'O'
                else:
                    newStr += 'X'

            board[i] = newStr


s = Solution()
matrix = ['XXXX', 'XOOX', 'XXOX', 'XOXX']
s.solve(matrix)
print(matrix)