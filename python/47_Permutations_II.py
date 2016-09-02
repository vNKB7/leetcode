#!/usr/bin/env python3

'''
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        numsDict = {}

        pre = None
        count = 0
        for i in range(len(nums)):
            if pre == nums[i]:
                count += 1
            else:
                if pre != None:
                    numsDict[pre] = count

                count = 1
                pre = nums[i]

        numsDict[pre] = count


        permutationList = [[]]
        for k,v in numsDict.items():
            listLen = len(permutationList)

            for i in range(listLen):
                curPerm = permutationList.pop(0)
                permutationList.extend(self.helper(k, v, curPerm[:], 0))

        return permutationList


    def helper(self, num, count, preList, start):
        result = []

        for j in range(start, len(preList)+1):
            newList = preList[:]
            newList.insert(j, num)

            if count == 1:
                result.append(newList)
            else:
                result.extend(self.helper(num, count-1, newList,j+1))

        return result
'''

#这段简短的代码之所以有效，是因为它使得重复的数字按一定的顺序排列。所以说这段代码的思想与上面我写的是一致的，也就是将重复的数字从无序变为有序。但他写得很好。特别是下面注释的那段。
class Solution(object):
    def permuteUnique(self, nums):
        nums = sorted(nums)
        res = []
        self.helper(nums, res, [], len(nums))
        return res
    def helper(self, nums, res, sub, size):
        if len(sub) == size:
            res.append(sub)
        for i in range(len(nums)):
            if i + 1 < len(nums) and nums[i] == nums[i + 1]:#由于这一步的判断，在重复的数字中，如1111，最后一个1会率先被提取并加入到sub中，也就是说四个1如果编号为1234，则在sub中的顺序永远是4321.
                continue
            else:
                self.helper(nums[:i]+nums[i + 1:], res, sub+[nums[i]], size)

s = Solution()
print(s.permuteUnique([-1,2,-1,2,1,-1,2,1]))