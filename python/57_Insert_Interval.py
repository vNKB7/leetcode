#!/usr/bin/env python3

# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        result = []

        i = 0
        intervalLen = len(intervals)

        state = 0

        start = newInterval.start

        while i < intervalLen:

            if newInterval.end < intervals[i].start:
                result.append(Interval(start, newInterval.end))
                result.extend(intervals[i:])
                return result
            elif start <= intervals[i].start:
                if newInterval.end <= intervals[i].end:
                    result.append(Interval(start, intervals[i].end))
                    result.extend(intervals[i+1:])
                    return result
                else:
                    i += 1
            elif intervals[i].start <= start <= intervals[i].end:
                start = intervals[i].start
                if newInterval.end <= intervals[i].end:
                    result.append(Interval(start, intervals[i].end))
                    result.extend(intervals[i+1:])
                    return result
                else:
                    i += 1
            else:
                result.append(intervals[i])
                i += 1

        result.append(Interval(start, newInterval.end))
        return result

s = Solution()
result = s.insert([Interval(1,3),Interval(2,6),Interval(8,10),Interval(15,18)], Interval(-1,3))
for x in result:
    print('%d, %d' % (x.start, x.end))