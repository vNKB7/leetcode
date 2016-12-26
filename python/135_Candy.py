#!/usr/bin/env python3

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if not ratings or len(ratings) == 0:
            return 0
        if len(ratings) == 1:
            return 1

        length = len(ratings)
        minimum = []
        maximum = []
        candy = [1] * length

        for i in range(length):
            if i == 0 and ratings[1] > ratings[0]:
                minimum.append(i)
            elif i == length - 1 and ratings[length-1] < ratings[length-2]:
                minimum.append(length-1)
            elif ratings[i-1] > ratings[i] and ratings[i+1] > ratings[i]:
                minimum.append(i)
            elif ratings[i-1] <= ratings[i] and ratings[i+1] <= ratings[i]:
                maximum.append(i)

        for i in range(len(minimum)):
            startPoint = minimum[i]
            endPoint = minimum[i+1]
            midPoint = maximum[i]

            for j in range(startPoint, midPoint):
                if ratings[j] < ratings[j+1]:
                    candy[j+1] = candy[j] + 1
                elif ratings[j] == ratings[j+1]
                    candy[j+1] = candy[j]
                if j + 1 == midPoint:
                    midCandyFake =

# die, die, die


s = Solution()
print(s.candy([4,2,3,2,3,2,1]))
