#!/usr/bin/env python2

class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        num = 0
        ops = []
        nums = []
        for c in input:
            if 0 <= ord(c) - ord('0') <= 9:
                num = num * 10 + int(c)
            else:
                nums.append(num)
                ops.append(c)
                num = 0
        nums.append(num)

        return self.help(ops, nums)

    def help(self, ops, nums):
        result = []
        if len(ops) == 0:
            return [nums[0]]
        elif len(ops) == 1:
            if ops[0] == '+':
                result.append(nums[0] + nums[1])
            elif ops[0] == '-':
                result.append(nums[0] - nums[1])
            else:
                result.append(nums[0] * nums[1])
            return result
        else:
            for i in range(len(ops)):
                left = self.help(ops[:i], nums[:i+1])
                right = self.help(ops[i+1:], nums[i+1:])
                for l in left:
                    for r in right:
                        if ops[i] == '+':
                            result.append(l + r)
                        elif ops[i] == '-':
                            result.append(l - r)
                        else:
                            result.append(l * r)
            return result

'''
看起来就像神迹一样
https://discuss.leetcode.com/topic/19894/1-11-lines-python-9-lines-c
'''


s = Solution()
print s.diffWaysToCompute('2*3-4*5')