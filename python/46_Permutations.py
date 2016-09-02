#!/usr/bin/env python3

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0:
            return []
        elif len(nums) == 1:
            return [nums]

        permutationList = self.help([], nums)
        return permutationList



    def help(self, preList, can):
        if len(can) == 0:
            return [preList]

        result = []
        for num in can:
            curCan = can[:]
            curCan.remove(num)
            result.extend(self.help(preList+[num], curCan))

        return result

s = Solution()
result = s.permute([1,2,3])

for l in result:
    print(l)