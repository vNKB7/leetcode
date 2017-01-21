#!/usr/bin/env python2

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        size = 0

        for i in range(1, len(nums)):
            for j in range(max(0, i-k), i):
                if -t <= nums[i]-nums[j] <= t:
                    return True

        return False

s = Solution()
print s.containsNearbyAlmostDuplicate([50,10,100,20,40], 3, 5)






