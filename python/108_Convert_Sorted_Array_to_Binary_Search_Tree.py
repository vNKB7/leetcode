#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if nums == None or len(nums) == 0:
            return None

        root = TreeNode(0)
        self.helper(nums, 0, len(nums), root)
        return root

    def helper(self, nums, start, end, root):
        if end - start == 1:
            root.val = nums[start]
            return

        mid = (start + end) // 2

        root.val = nums[mid]

        if mid - start > 0:
            root.left = TreeNode(0)
            self.helper(nums, start, mid, root.left)
        if end - 1 - mid > 0:
            root.right = TreeNode(0)
            self.helper(nums, mid + 1, end, root.right)




