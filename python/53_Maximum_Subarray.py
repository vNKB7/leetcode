#!/usr/bin/env python3

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return None
        elif len(nums) == 1:
            return nums[0]

        maxSum = nums[0]

        #情况1：没有正数，则找最大的单个数。否则，找到第一个正数。
        for i in range(len(nums)):
            if nums[i] > 0:
                maxSum = nums[i]
                break

            if nums[i] > maxSum:
                maxSum = nums[i]

        if maxSum < 0:
            return maxSum

        start = i
        tmpMax = maxSum

        #tmpMax为以正数开头的一系列数的和。当加下一个数后发现还不如直接从下一个数重新开始来的大，则从下一个数开始。
        for i in range(start+1, len(nums)):
            if tmpMax + nums[i] > nums[i]:
                tmpMax += nums[i]
            else:
                tmpMax = nums[i]

            if tmpMax > maxSum:
                maxSum = tmpMax

        return maxSum


'''
#上面代码的简化版本，为什么别人的代码写得这么好。
def maxSubArray(self, nums):
        sum, maxSum = 0, 0
        for n in nums:
            sum += n
            if sum < 0:
                sum = 0
            maxSum = max(maxSum, sum)
        return maxSum if maxSum > 0 else max(nums)
'''



s = Solution()
print(s.maxSubArray([-2,-1]))
