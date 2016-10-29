#!/usr/bin/env python3
import copy
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        result = [[]]

        for num in nums:
            newList = copy.deepcopy(result)#注意，因为这里是list中有list的情况，浅拷贝会出现问题。已经吃了很多次亏了！！！
            for x in newList:
                x.append(num)
            result.extend(newList)

        return result

'''
#同样的思路，一个更漂亮的实现
def subsets(self, nums):
    return_lis = [[]]

    for n in nums:
        temp_lis = return_lis[:]
        for r in temp_lis:
            return_lis.append(r+[n])

    return return_lis

'''

s = Solution()
print(s.subsets([1,2,3]))