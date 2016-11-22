#!/usr/bin/env python3

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxVal = 0
        curVal = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            curVal += diff
            if curVal > maxVal:
                maxVal = curVal
            elif curVal < 0:
                curVal = 0
        return maxVal

s = Solution()
print(s.maxProfit([2,1,4,5,2,9,7]))


'''
public int maxProfit(int[] prices) {

    int min = Integer.MAX_VALUE;
    int max = 0;

    for(int p:prices) {
        min = Math.min(min, p);
        max = Math.max(p-min, max);
    }

    return max;
}
'''



