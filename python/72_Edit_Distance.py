#!/usr/bin/env python3

'''
#动态规划 列值版
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        self.bin = {}
        if len(word1) == 0 or len(word2) == 0:
            return max(len(word1), len(word2))

        return self.helper(word1, word2)

    def helper(self, word1, word2):
        min = 10000

        if word1 == word2:
            return 0
        if ' '.join([word1, word2]) in self.bin:
            return self.bin[' '.join([word1, word2])]
        else:
            if len(word1) == 1 and len(word2) == 1:
                if word1[0] == word2[0]:
                    return 0
                else:
                    return 1
            elif len(word1) == 1:
                if word1[0] in word2:
                    return len(word2) - 1
                else:
                    return len(word2)
            elif len(word2) == 1:
                if word2[0] in word1:
                    return len(word1) - 1
                else:
                    return len(word1)

            for i in range(1, len(word1)):
                for j in range(1, len(word2)):
                    distance = self.helper(word1[:i], word2[:j]) + self.helper(word1[i:], word2[j:])

                    if distance == 0:
                        return 0

                    if distance < min:
                        min = distance
            self.bin[' '.join([word1, word2])] = min

            return min
'''


'''
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        c = {}
        for i in range(len(word1)+1):
            c[(i, 0)] = i
        for i in range(len(word2)+1):
            c[(0, i)] = i

        for i in range(1, len(word1)+1):
            for j in range(1, len(word2)+1):
                c[(i, j)] = min(c[i-1, j]+1 , c[i, j-1]+1, c[(i-1, j-1)] + (0 if word1[i-1] == word2[j-1] else 1))

        return c[(len(word1), len(word2))]
'''

class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        if len(word1) == 0 or len(word2) == 0:
            return max(len(word1), len(word2))

        c = [[0]*(len(word2)+1), [0]*(len(word2)+1)]

        for i in range(len(word2)+1):
            c[0][i] = i

        c[0][0] = 0
        c[1][0] = 1

        col0 = 0
        col1 = 1
        for i in range(1, len(word1)+1):
            c[col1][0] = i
            for j in range(1, len(word2)+1):
                c[col1][j] = min(c[col0][j]+1, c[col1][j-1]+1, c[col0][j-1] + (0 if word1[i-1] == word2[j-1] else 1))

            col0, col1 = col1, col0


        return c[col0][len(word2)]




s = Solution()
print(s.minDistance("123", "1234"))