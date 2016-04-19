#!/usr/bin/env python

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1.extend(nums2)
        array = nums1
        array.sort()
        if len(array) % 2 == 0:
            return (array[int((len(array)/2))-1]+array[int(len(array)/2)])/2
        else:
            return array[int((len(array)+1)/2)-1]

s = Solution()
print(s.findMedianSortedArrays([],[2,3]))