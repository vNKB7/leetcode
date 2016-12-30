#!/usr/bin/env python3

# Definition for a point.
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

'''
(y-y1)/(y2-y1) = (x-x1)/(x2-x1)
'''

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        if not points or len(points) == 0:
            return 0

        unique = {}
        for eachPoint in points:
            if (eachPoint.x, eachPoint.y) not in unique:
                unique[(eachPoint.x, eachPoint.y)] = 0
            unique[(eachPoint.x, eachPoint.y)] += 1

        points = [k for k in unique.keys()]

        lineList = []
        for i in range(1, len(points)):
            p = points[i]
            filerSet = set()
            for line in lineList:
                x1, y1, x2, y2 = line[0]

                if self.inLine(x1, y1, x2, y2, p[0], p[1]):
                    line[1] += unique[(p[0], p[1])]
                    filerSet |= set(line[2])
                    line[2].append((p[0], p[1]))
            for j in range(i):
                if (points[j][0], points[j][1]) not in filerSet:
                    count = unique[(points[j][0], points[j][1])] + unique[(p[0], p[1])]
                    lineList.append([[points[j][0], points[j][1], p[0], p[1]], count, [(points[j][0], points[j][1]), (p[0], p[1])]])

        maxC = max(unique.values())
        for line in lineList:
            if line[1] > maxC:
                maxC = line[1]
        # for line in lineList:
        #     print('(%d, %d)->(%d, %d) count = %d :' % (line[0][0], line[0][1], line[0][2], line[0][3], line[1]), end='')
        #     for tmp in line[2]:
        #         print('(%d, %d) ' % (tmp[0], tmp[1]), end='')
        #     print()

        return maxC

    def inLine(self, x1, y1, x2, y2, x, y):
        if y1 == y2:
            if y1 == y:
                return True
            else:
                return False
        if x1 == x2:
            if x1 == x:
                return True
            else:
                return False
        return (y-y1)/(y2-y1) == (x-x1)/(x2-x1)



s = Solution()
p_list = [Point(-4,-4), Point(-8,-582), Point(-3,3), Point(-9,-651), Point(9,591)]
print(s.maxPoints(p_list))
# print(s.inLine(1,1,2,2,1,1))

# 在本地运行可以，上leetcode不行
