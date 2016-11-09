#!/usr/bin/env python3


#very slow
class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """

        bitsList = [False] * n
        numList = [0]
        numSet = {0}
        curValue = 0
        biList = [1] * n
        for i in range(1, n):
            biList[i] = biList[i-1] * 2

        i = 0
        count = 2**n - 1
        while i < count:
            i += 1
            for j in range(n):
                if bitsList[j] and curValue - biList[j] not in numSet:
                    bitsList[j] = False
                    curValue -= biList[j]
                    numList.append(curValue)
                    numSet.add(curValue)
                    break
                elif not bitsList[j] and curValue + biList[j] not in numSet:
                    bitsList[j] = True
                    curValue += biList[j]
                    numList.append(curValue)
                    numSet.add(curValue)
                    break

        return numList

s = Solution()
print(s.grayCode(3))

''' unbelievable
class Solution(object):

    def grayCode(self, n):

        return [x ^ (x >> 1) for x in range(0, 1 << n)]
'''