#!/usr/bin/env python3

'''
#out of time limit
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numLen = len(nums)
        minStep = [1000000] * numLen
        minStep[numLen-1] = 0
        for i in range(numLen-1)[::-1]:
            maxStep = nums[i]
            for step in range(0, maxStep + 1)[::-1]:
                if(i + step >= numLen):
                    minStep[i] = 1
                    break
                else:
                    tmpStep = minStep[i+step]+1
                    if tmpStep < minStep[i]:
                        minStep[i] = tmpStep

        for num in nums:
            print('%d ' % num, end='')

        print()

        for num in minStep:
            print('%d ' % num, end='')

        return minStep[0]

s = Solution()
s.jump()
'''

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        jumpCount = 0
        farthestStep = 0
        lastStep = 0

        numsLen = len(nums)

        #特殊情况
        if(numsLen == 1):
            return 0

        while farthestStep <= numsLen - 1:
            jumpCount += 1
            curFarthestStep = farthestStep

            for index in range(lastStep, farthestStep+1):
                if nums[index] + index > curFarthestStep:
                    curFarthestStep = nums[index] + index
                    if curFarthestStep >= numsLen-1:
                        return jumpCount

            lastStep = farthestStep+1
            farthestStep = curFarthestStep

s = Solution()
print(s.jump([1,2,1,1]))
