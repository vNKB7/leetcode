#!/usr/bin/env python2

'''
# Time Limit Exceeded
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
'''

import collections

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if k < 1 or t < 0:
            return False

        numDict = collections.OrderedDict()

        for i in range(len(nums)):
            key = nums[i] / max(1,t)

            for m in (key-1, key, key+1):
                if m in numDict and abs(nums[i] - numDict[m]) <= t:
                    return True

            numDict[key] = nums[i]

            if i >= k:
                numDict.popitem(last=False)

        return False


s = Solution()
print s.containsNearbyAlmostDuplicate([50,10,100,20,40], 3, 5)






