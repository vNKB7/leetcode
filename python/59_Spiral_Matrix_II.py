#!/usr/bin/env python3

class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        matrix = []

        if n <= 0:
            return matrix

        for i in range(n):
            row = [0 for i in range(n)]
            matrix.append(row)

        maxLen = n * n
        m_s = 0
        m_e = n-1
        n_s = 0
        n_e = n-1

        x = 0
        y = 0

        matrix[0][0] = 1
        count = 1
        state = 0
        while True:
            if state == 0:
                if y == n_e:
                    m_s += 1
                    state = 1
                else:
                    y += 1
                    count += 1
                    matrix[x][y] = count
            elif state == 1:
                if x == m_e:
                    n_e -= 1
                    state = 2
                else:
                    x += 1
                    count += 1
                    matrix[x][y] = count
            elif state == 2:
                if y == n_s:
                    m_e -= 1
                    state = 3
                else:
                    y -= 1
                    count += 1
                    matrix[x][y] = count
            elif state == 3:
                if x == m_s:
                    n_s += 1
                    state = 0
                else:
                    x -= 1
                    count += 1
                    matrix[x][y] = count


            if count == maxLen:
                break

        return matrix

s = Solution()
print(s.generateMatrix(3))
