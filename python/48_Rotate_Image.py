class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)

        if n % 2 == 0:
            for x in range((int)(n/2)):
                for y in range((int)(n/2)):
                    x1 = n-1-y
                    y1 = x
                    tmp = matrix[x1][y1]
                    for i in range(3):
                        x2 = n-1-y1
                        y2 = x1
                        matrix[x1][y1] = matrix[x2][y2]
                        x1 = x2
                        y1 = y2
                    matrix[x1][y1] = tmp
        else:
            for x in range((int)((n-1)/2)):#应尝试修改/以合并两种情况
                for y in range((int)((n+1)/2)):
                    x1 = n-1-y
                    y1 = x
                    tmp = matrix[x1][y1]
                    for i in range(3):
                        x2 = n-1-y1
                        y2 = x1
                        matrix[x1][y1] = matrix[x2][y2]
                        x1 = x2
                        y1 = y2
                    matrix[x1][y1] = tmp

s = Solution()
matrix = [[1,2],[3,4]]
s.rotate(matrix)
print(matrix)