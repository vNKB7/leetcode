#!/usr/bin/env python2

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        set_size = 0
        num_set = set()
        for i in range(len(nums)):
            if set_size == k + 1:
                num_set.remove(nums[i-k-1])
            if nums[i] in num_set:
                return True
            else:
                num_set.add(nums[i])
            if set_size <= k:
                set_size += 1

        return False

s = Solution()
print s.containsNearbyDuplicate([1,2,3,4,2,6,7,8,9], 3)