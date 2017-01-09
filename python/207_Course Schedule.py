#!/usr/bin/env python

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        request_dict = {}

        for item in prerequisites:
            if item[1] not in request_dict:
                request_dict[item[1]] = []
            request_dict[item[1]].append(item[0])

        visited = [0] * numCourses

        for i in range(numCourses):
            if visited[i] == 0:
                if not self.DFS(visited, request_dict, i):
                    return False

        return True

    def DFS(self, visited, request_dict, curNode):
        if visited[curNode] == -1:
            return False
        elif visited[curNode] == 1:
            return True
        elif curNode not in request_dict:
            return True
        else:
            for item in request_dict[curNode]:
                visited[curNode] = -1
                if not self.DFS(visited, request_dict, item):
                    return False
            visited[curNode] = 1
            return True

s = Solution()
print(s.canFinish(4, [[1,0],[2,1],[3,2],[1,3]]))


