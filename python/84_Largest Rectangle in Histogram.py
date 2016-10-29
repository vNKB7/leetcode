#!/usr/bin/env python3

#O(n^2)
# class Solution(object):
#     def largestRectangleArea(self, heights):
#         """
#         :type heights: List[int]
#         :rtype: int
#         """
#         if heights is None or len(heights) == 0:
#             return 0
#
#         primMaxArea = 0
#         for i in range(len(heights)-1):
#             maxArea = heights[i]
#             minHeight = heights[i]
#             for j in range(i+1, len(heights)):
#                 if heights[j] < minHeight:
#                     minHeight = heights[j]
#                 area = minHeight * (j - i + 1)
#                 if area > maxArea:
#                     maxArea = area
#
#             if maxArea > primMaxArea:
#                 primMaxArea = maxArea
#
#         return max(primMaxArea, heights[-1])


#O(nlog(n))
#最坏情况(n^2)  [0,1,2,3,4,5,6,7,8,9,10]
# class Solution(object):
#     def largestRectangleArea(self, heights):
#         """
#         :type heights: List[int]
#         :rtype: int
#         """
#         if heights is None or len(heights) == 0:
#             return 0
#         return self.helper(heights, 0, len(heights))
#
#
#     def helper(self, heights, start, end):
#         if end - start == 1:
#             return heights[start]
#         elif end <= start:
#             return 0
#
#         minIndex, min = self.findMin(heights, start, end)
#         curArea = (end - start) * min
#
#
#         maxSubArea = max(self.helper(heights, start, minIndex), self.helper(heights, minIndex+1, end))
#         return max(curArea, maxSubArea)
#
#
#     def findMin(self, myList, start, end):
#         min = myList[start]
#         minIndex = start
#         for i in range(start+1, end):
#             if myList[i] < min:
#                 min = myList[i]
#                 minIndex = i
#         return minIndex, min

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        stack = []
        heights.append(0)
        maxArea = 0

        i = 0
        while i < len(heights):

            while len(stack) != 0 and heights[i] < heights[stack[-1]]:
                preIndex = stack.pop()
                area = heights[preIndex] * (i - preIndex)
                if maxArea < area:
                    maxArea = area
            stack.append(i)
            i += 1
        return maxArea




s = Solution()
print(s.largestRectangleArea([2,1,2]))