#!/usr/bin/env python3

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        if board == None or len(board) == 0:
            return False

        if word == None or len(board) == 0:
            return False

        self.n = len(board)
        self.m = len(board[0])

        for i in range(self.n):
            for j in range(self.m):
                if board[i][j] == word[0]:
                    path = set()
                    path.add((i, j))
                    if self.helper(board, path, i, j, 1, word):
                        return True
        return False

    def helper(self, board, path, x, y, depth, word):
        if depth == len(word):
            return True

        if x - 1 >= 0 and (x-1, y) not in path and board[x-1][y]==word[depth]:
            newPath = set(path)
            newPath.add((x-1, y))
            if self.helper(board, newPath, x-1, y, depth+1, word):
                return True

        if x + 1 < self.n and (x+1, y) not in path and board[x+1][y]==word[depth]:
            newPath = set(path)
            newPath.add((x+1, y))
            if self.helper(board, newPath, x+1, y, depth+1, word):
                return True

        if y - 1 >= 0 and (x, y-1) not in path and board[x][y-1]==word[depth]:
            newPath = set(path)
            newPath.add((x, y-1))
            if self.helper(board, newPath, x, y-1, depth+1, word):
                return True

        if y + 1 < self.m and (x, y+1) not in path and board[x][y+1]==word[depth]:
            newPath = set(path)
            newPath.add((x, y+1))
            if self.helper(board, newPath, x, y+1, depth+1, word):
                return True

        return False



s = Solution()
print(s.exist(["ab"],"ab"))