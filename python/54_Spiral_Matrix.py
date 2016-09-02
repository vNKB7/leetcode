#!/usr/bin/env python3

class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if matrix == None or len(matrix) == 0 or matrix[0] == None or len(matrix[0]) == 0:
            return []

        result = []

        m = len(matrix)
        n = len(matrix[0])
        maxLen = m * n
        m_s = 0
        m_e = len(matrix)-1
        n_s = 0
        n_e = len(matrix[0])-1

        x = 0
        y = 0

        result.append(matrix[x][y])
        count = 1
        state = 0
        while True:
            if state == 0:
                if y == n_e:
                    m_s += 1
                    state = 1
                else:
                    y += 1
                    result.append(matrix[x][y])
                    count += 1
            elif state == 1:
                if x == m_e:
                    n_e -= 1
                    state = 2
                else:
                    x += 1
                    result.append(matrix[x][y])
                    count += 1
            elif state == 2:
                if y == n_s:
                    m_e -= 1
                    state = 3
                else:
                    y -= 1
                    result.append(matrix[x][y])
                    count += 1
            elif state == 3:
                if x == m_s:
                    n_s += 1
                    state = 0
                else:
                    x -= 1
                    result.append(matrix[x][y])
                    count += 1

            if count == maxLen:
                break

        return result

s = Solution()
print(s.spiralOrder([[ 1, 2, 3 ],[ 4, 5, 6 ],[ 7, 8, 9 ]]))