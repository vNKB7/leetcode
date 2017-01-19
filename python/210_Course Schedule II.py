#!/usr/bin/env python2

class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """

        indegressCount = [0] * numCourses
        adjs = [[] for _ in range(numCourses)]
        zeros = []
        result = []

        for item in prerequisites:
            adjs[item[1]].append(item[0])
            indegressCount[item[0]] += 1

        zeros = [x for x in range(numCourses) if indegressCount[x] == 0]

        while len(zeros) > 0:
            zero = zeros.pop(0)
            result.append(zero)
            for node in adjs[zero]:
                indegressCount[node] -= 1
                if indegressCount[node] == 0:
                    zeros.append(node)

        if len([x for x in indegressCount if x != 0]) > 0:
            return []
        else:
            return result


s = Solution()
print(s.findOrder(2, [[0,1]]))










