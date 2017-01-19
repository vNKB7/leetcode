#!/usr/bin/env python2
# coding: utf-8

class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        m = len(board)
        n = len(board[0])
        wordsPath = []
        for index in range(len(words)):
            path = []
            for i in range(m):
                for j in range(n):
                    if board[i][j] == words[index][0]:
                        path.extend(self.findWord(board, words[index], 0, set([(i,j)]), i, j))
            wordsPath.append(path)
        result = self.helper(wordsPath, 0, set(), [])
        return result

    def helper(self, wordsPath, index, visited, maxPath):
        if index == len(wordsPath):
            return []
        wordPath = wordsPath[index]
        max = -1
        t_maxPath = maxPath
        for path in wordPath:
            new_visited = set(visited)
            new_path = t_maxPath[:]
            new_path.append(path)
            if len(visited & path) > 0:
                r = self.helper(wordsPath, index+1, new_visited, new_path)
            else:
                new_visited |= path
                r = self.helper(wordsPath, index+1, new_visited, new_path)
            if max < len(r):
                max = len(r)
                maxPath = new_path

        return maxPath

    # 给定broad和单个的word，给出所有备选的word坐标
    def findWord(self, board, word, index, posList, x, y):
        if len(word) == index + 1:
            return [set(posList)]

        index += 1
        result = []
        if x > 0:
            if board[x-1][y] == word[index] and (x-1,y) not in posList:
                newList = set(posList)
                newList.add((x-1, y))
                result.extend(self.findWord(board, word, index, newList, x-1, y))
        if x < len(board)-1:
            if board[x+1][y] == word[index] and (x+1,y) not in posList:
                newList = set(posList)
                newList.add((x+1, y))
                result.extend(self.findWord(board, word, index, newList, x+1, y))
        if y > 0:
            if board[x][y-1] == word[index] and (x,y-1) not in posList:
                newList = set(posList)
                newList.add((x, y-1))
                result.extend(self.findWord(board, word, index, newList, x, y-1))
        if y < len(board[0])-1:
            if board[x][y+1] == word[index] and (x,y+1) not in posList:
                newList = set(posList)
                newList.add((x, y+1))
                result.extend(self.findWord(board, word, index, newList, x, y+1))
        return result

s = Solution()
print(s.findWords(['123','234','345'], ['123', '345']))