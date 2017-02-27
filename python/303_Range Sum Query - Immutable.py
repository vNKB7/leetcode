#!/usr/bin/env python2

class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.array = [0]
        for num in nums:
            self.array += self.array[-1] + num, # ????

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.array[j+1] - self.array[i]


# Your NumArray object will be instantiated and called as such:
numArray = NumArray([1,2,3,4,5])
numArray.sumRange(0, 1)
numArray.sumRange(1, 2)