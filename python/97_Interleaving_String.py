#!/usr/bin/env python3


# Time Limit Exceeded
# class Solution(object):
#     def isInterleave(self, s1, s2, s3):
#         """
#         :type s1: str
#         :type s2: str
#         :type s3: str
#         :rtype: bool
#         """
#         if len(s1) + len(s2) != len(s3):
#             return False
#         return self.helper(s1, s2, s3, 0, 0, 0)
#
#     def helper(self, s1, s2, s3, i1, i2, i3):
#         if i3 == len(s3):
#             return True
#
#         result1 = result2 = False
#         if i1 < len(s1) and s3[i3] == s1[i1]:
#             result1 = self.helper(s1, s2, s3, i1 + 1, i2, i3 + 1)
#         if i2 < len(s2) and s3[i3] == s2[i2]:
#             result2 =  self.helper(s1, s2, s3, i1, i2 + 1, i3 + 1)
#         return result1 or result2

class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s1) + len(s2) != len(s3):
            return False
        
        m = len(s1)+1
        n = len(s2)+1

        matrix = [[0 for i in range(n)] for j in range(m)]
        matrix[0][0] = 1
        for i in range(m):
            for j in range(n):
                if i > 0:
                    if matrix[i-1][j] == 1 and s3[i + j - 1] == s1[i-1]:
                        matrix[i][j] = 1

                if j > 0:
                    if matrix[i][j-1] == 1 and s3[i + j - 1] == s2[j-1]:
                        matrix[i][j] = 1

        return matrix[m-1][n-1] == 1


s = Solution()

print(s.isInterleave('a', 'b', 'a'))
#print(s.isInterleave('ace', 'bd', 'abcde'))
#print(s.isInterleave("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb","ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc","cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"))