#!/usr/bin/env python2
#coding=utf-8

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        p = [[0] * n for _ in range(n)]
        s = [[0] * n for _ in range(n)]
        for i in range(n):
            p[i][i] = nums[i]

        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                for k in range(i, j + 1):
                    p[i][j] = max(p[i][j], (p[i][k-1] if i <= k-1 else 0) + (p[k+1][j] if k+1 <= j else 0) + (nums[k-1] if k - 1 >= 0 else 1)*nums[k]*(nums[k+1] if k+1<n else 1))
                    s[i][j] = k
        return p[0][-1]

s = Solution()
print s.maxCoins([2])



