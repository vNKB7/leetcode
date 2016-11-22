#!/usr/bin/env python3

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """

        val = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            if diff > 0:
                val += diff

        return val

s = Solution()
print(s.maxProfit([2,1,4,5,2,9,7]))

