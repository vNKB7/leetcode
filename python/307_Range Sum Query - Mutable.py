#!/usr/bin/env python2
'''
class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        if not nums or len(nums) == 0:
            self.nums = []
            self.store = []
        else:
            self.nums = nums
            self.store = [nums[0]]
            for num in nums[1:]:
                self.store.append(num + self.store[-1])

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        diff = val - self.nums[i]
        self.nums[i] = val
        for j in range(i, len(self.store)):
            self.store[j] += diff


    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.store[j] - (self.store[i-1] if i > 0 else 0)
'''
class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        if not nums or len(nums) == 0:
            return
        self.root = self.build_tree(0, len(nums)-1, nums)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        self.updateTree(self.root, i, val)

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.getSum(self.root,i, j)

    class TreeNode(object):
        def __init__(self, left, right, sum, left_child, right_child):
            self.left = left
            self.right = right
            self.sum = sum
            self.left_child = left_child
            self.right_child = right_child

    def build_tree(self, start, end, nums):
        if start == end:
            node = self.TreeNode(start, end, nums[start], None, None)
        else:
            mid = (start + end) / 2
            left_child = self.build_tree(start, mid, nums)
            right_child = self.build_tree(mid+1, end, nums)
            sum = left_child.sum + right_child.sum
            node = self.TreeNode(start, end, sum, left_child, right_child)
        return node

    def getSum(self, root, i, j):
        if not root:
            return 0
        if root.left == i and root.right == j:
            return root.sum
        mid = (root.left + root.right) / 2
        if mid >= j:
            return self.getSum(root.left_child, i, j)
        elif mid < i:
            return self.getSum(root.right_child, i, j)
        else:
            return self.getSum(root.left_child, i, mid) + self.getSum(root.right_child, mid+1, j)

    def updateTree(self, root, i, val):
        if not root:
            return
        if root.left == root.right:
            root.sum = val
            return
        mid = (root.left + root.right) / 2
        if i <= mid:
            self.updateTree(root.left_child, i, val)
        else:
            self.updateTree(root.right_child, i, val)
        root.sum = root.left_child.sum + root.right_child.sum


# Your NumArray object will be instantiated and called as such:
obj = NumArray([0, 9, 5, 7 ,3])
print obj.sumRange(4, 4)
print obj.sumRange(2, 4)

#print obj.sumRange()
#obj.update()
