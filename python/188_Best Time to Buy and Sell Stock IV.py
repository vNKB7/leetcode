#!/usr/bin/env python3


#解法在onenote中有记录。DP用得很厉害，不是我的程度能做出来的。
class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if k < 1:
            return 0

        if k >= len(prices): # 这里是必须的，不然会碰到下面例子中的情况（内存不够），导致无法通过。
            val = 0
            for i in range(1, len(prices)):
                diff = prices[i] - prices[i-1]
                if diff > 0:
                    val += diff
            return val

        global_max = [0] * (k+1)
        local_max = [0] * (k+1)

        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            for j in range(1, k+1)[::-1]:
                local_max[j] = max(global_max[j-1] + max(diff, 0), local_max[j] + diff)
                global_max[j] = max(local_max[j], global_max[j])

        return global_max[-1]

s = Solution()
print(s.maxProfit(4 ,[1,2,3]))
