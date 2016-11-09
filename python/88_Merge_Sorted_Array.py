#!/usr/bin/env python3

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """

        mergeList = []

        i = j = 0
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                mergeList.append(nums1[i])
                i += 1
            else:
                mergeList.append(nums2[j])
                j += 1

        while i < m:
            mergeList.append(nums1[i])
            i += 1

        while j < n:
            mergeList.append(nums2[j])
            j += 1

        if len(nums1) < m + n:
            nums1.extend([0]*(m + n - len(nums1)))

        for i in range(len(mergeList)):
            nums1[i] = mergeList[i]

s = Solution()
nums1 = [1,2,3,4]
nums2 = [6,7,8,9]
s.merge(nums1, 2, nums2, 4)
print(nums1)
