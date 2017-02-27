#!/usr/bin/env python2
#coding=utf8

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        memory = [float('inf')] * (amount + 1)
        memory[0] = 0
        for i in range(1, amount+1):
            for c in coins:
                if i >= c:
                    memory[i] = min(memory[i], 1 + min([memory[i-c] for c in coins if i - c >= 0] + [float('inf')]))
        if memory[-1] == float('inf'):
            return -1
        else:
            return memory[-1]

s = Solution()
print s.coinChange([70,177,394,428,427,437,176,145,83,370],7582)

# https://discuss.leetcode.com/topic/32589/fast-python-bfs-solution
# https://discuss.leetcode.com/topic/35720/easy-to-understand-recursive-dp-solution-using-java-with-explanations