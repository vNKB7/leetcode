#!/usr/bin/env python2
#coding=utf8

class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        gt = False
        for i in range(len(nums)-1):
            if gt:
                if nums[i] <
