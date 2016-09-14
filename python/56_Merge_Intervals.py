#!/usr/bin/env python3

#实现一个并查集
# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class UF(object):
    def __init__(self, count):
        self.count = count
        self.id = [i for i in range(count)]
        self.unionCount = count

    def count(self):
        return self.count

    def connected(self, p, q):
        return self.find(p) == self.find(q)

    def find(self, p):
        return self.id[p]

    def union(self, p, q):
        pID = self.id[p]
        qID = self.id[q]

        if pID == qID:
            return

        self.unionCount -= 1
        for i in range(len(self.id)):
            if self.id[i] == pID:
                self.id[i] = qID

    def getSets(self):
        remainId = set()

        for index in self.id:
            remainId.add(index)

        tmpSet = []

        for index in remainId:
            tmpList = []
            for i in range(len(self.id)):
                if self.id[i] == index:
                    tmpList.append(i)
            tmpSet.append(tmpList)

        return tmpSet

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        uf = UF(len(intervals))

        if intervals is None or len(intervals) == 0:
            return []

        for i in range(len(intervals)-1):
            for j in range(i+1, len(intervals)):
                if not (intervals[i].end < intervals[j].start or intervals[j].end < intervals[i].start):
                    uf.union(i, j)

        sets = uf.getSets()

        result = []

        for curSet in sets:
            result.append(Interval(min([intervals[i].start for i in curSet]), max([intervals[i].end for i in curSet])))

        return result



s = Solution()
print(s.merge([Interval(1,3),Interval(2,6),Interval(8,10),Interval(15,18)]))






