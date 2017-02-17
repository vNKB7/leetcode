#!/usr/bin/env python2

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices) < 2:
            return 0
        buy = [0] * len(prices)
        sell = [0] * len(prices)

        buy[0] = -prices[0]
        buy[1] = max(-prices[0], -prices[1])
        sell[0] = 0
        sell[1] = max(sell[0], buy[0]+prices[1])
        for i in range(2, len(prices)):
            buy[i]= max(buy[i-1], sell[i-2]-prices[i])
            sell[i] = max(sell[i-1], buy[i-1]+prices[i])

        return sell[-1]

