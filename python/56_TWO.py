#!/usr/bin/env python3

# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        result = []

        queue = list(intervals)

        while True:
            if len(queue) == 0:
                return result

            cur = queue.pop(0)
            mergeList = []
            for i in range(len(queue)):
                if not (queue[i].end < cur.start or cur.end < queue[i].start):
                    mergeList.append(i)
                    cur = Interval(min(cur.start, queue[i].start), max(cur.end, queue[i].end))

            if len(mergeList) == 0:
                result.append(cur)
            else:
                for i in mergeList[::-1]:
                    queue.pop(i)
                queue.append(cur)

s = Solution()
result = s.merge([Interval(2,3),Interval(5,5),Interval(2,2),Interval(3,4),Interval(3,4)])
for x in result:
    print('%d, %d' % (x.start, x.end))
