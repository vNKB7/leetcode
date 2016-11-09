#!/usr/bin/env python3

class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        sorted(nums)
        numDict = {}
        resultList = [[]]

        for num in nums:
            if num in numDict:
                numDict[num] = numDict[num]+1
            else:
                numDict[num] = 1

        for k, v in numDict.items():
            tempList = resultList[:]

            for r in tempList:
                for i  in range(1, v+1):
                    resultList.append(r + ([k] * i))

        return resultList


s = Solution()
print(s.subsetsWithDup([1,2,2]))






