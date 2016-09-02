#!/usr/bin/env python3

#易见，当出现0时不能跳转的情况才可能发生
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        if nums == None or len(nums) == 0:
            return False

        if len(nums) == 1:
            return True

        if 0 not in nums:
            return True

        start = 0
        end = 0

        numsLen = len(nums)

        #特殊情况
        if(numsLen == 1):
            return 0

        while end <= numsLen - 1:
            curFarthestStep = end

            for index in range(start, end+1):
                if nums[index] + index > curFarthestStep:
                    curFarthestStep = nums[index] + index
                    if curFarthestStep >= numsLen-1:
                        return True

            flag = False
            for num in nums[end+1:curFarthestStep + 1]:#广度搜索的一轮中，如果全部是零，则终点不可达。
                if num != 0:
                    flag = True
            if not flag:
                return False

            start = end+1
            end = curFarthestStep


s = Solution()
print(s.canJump([3,2,1,0,4]))