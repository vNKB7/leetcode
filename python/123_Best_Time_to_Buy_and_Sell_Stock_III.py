#!/usr/bin/env python3

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxVal, start, end, minA = self.findMax(prices)

        val1, _, _, _ = self.findMax(prices[:start])
        val2, _, _, _ = self.findMax(prices[end+1:])
        return maxVal + max(val1, val2, -minA)

    def findMax(self, prices):
        maxVal = 0
        curVal = 0
        curS = 0
        maxS = 0
        maxE = 0
        curA = 0
        minA = 0
        realMinA = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            if diff < 0:
                curA += diff
                if curA < minA:
                    minA = curA
            else:
                curA = 0

            curVal += diff
            if curVal > maxVal:
                maxVal = curVal
                maxS = curS
                maxE = i
                if realMinA > minA:
                    realMinA = minA
            elif curVal < 0:
                curVal = 0
                curS = i
                minA = 0
        return maxVal, maxS, maxE, realMinA

s = Solution()
print(s.maxProfit([1,4,2]))