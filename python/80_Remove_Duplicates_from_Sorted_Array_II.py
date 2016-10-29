#!/usr/bin/env python3

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if nums == None or len(nums) == 0:
            return 0

        if len(nums) == 1:
            return 1

        newNums = [nums[0]]
        i = 1
        length = len(nums)
        state = 0
        count = 1

        while i < length:
            if state == 0:
                if nums[i] == nums[i-1]:
                    state = 1
                count += 1
                newNums.append(nums[i])

            elif state == 1:
                if nums[i] != nums[i-1]:
                    count += 1
                    newNums.append(nums[i])
                    state = 0
            i += 1

        for i in range(count):
            nums[i] = newNums[i]

        return count


    # def removeDuplicates(self, nums):
    #     i = 0
    #     for n in nums:
    #         if i < 2 or n > nums[i-2]:
    #             nums[i] = n
    #             i += 1
    #     return i


s = Solution()
m = [1,2,2,2,3,3,4]
print(s.removeDuplicates(m))
print(m)