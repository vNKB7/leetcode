#!/usr/bin/env python3

'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        duplicate = set()
        for num in nums:
            if num not in duplicate:
                duplicate.add(num)
            else:
                duplicate.remove(num)
        for i in duplicate:
            return i
'''

'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        i = 0
        while i < len(nums)-1:
            if nums[i] != nums[i+1]:
                return nums[i]
            i += 2
        return nums[-1]
'''

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for n in nums:
            result ^= n

        return result


s = Solution()
print(s.singleNumber([1,2,3,4,5,4,3,2,1]))