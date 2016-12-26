#!/usr/bin/env python3

# version 1, 超时

# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         """
#         :type s: str
#         :type wordDict: Set[str]
#         :rtype: bool
#         """
#         if not s or len(s) == 0:
#             return True
#
#         flag = False
#         for i in range(len(s)):
#             w = s[:i+1]
#             if s[:i+1] in wordDict:
#                 flag = flag or self.wordBreak(s[i+1:], wordDict)
#                 if flag:
#                     break
#         return flag

# version 2  动态规划

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """

        temp = []

        for i in range(len(s)):
            str = s[:i+1]
            if str in wordDict:
                temp.append(i)
            else:
                for index in temp:
                    str2 = s[index+1:i+1]
                    if str2 in wordDict:
                        temp.append(i)
                        break #这个break很重要，不然就超时了。只要找到一种切分方式就说明长度为i的单词可以成功切分，因此可以跳出内层循环。
        if not len(temp):
            return False
        else:
            return temp[-1] == len(s)-1

# version 3

# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         """
#         :type s: str
#         :type wordDict: Set[str]
#         :rtype: bool
#         """
#




s = Solution()
count = 0
str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}
maxMiss = max([len(x) for x in wordDict])
for i in range(len(str)):
    if(s.wordBreak(str[:i+1], wordDict)):
        count = 0
    else:
        count += 1
    if count >= maxMiss:
        print(False)
    print(i)
print(True)
# print(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
# , {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}))
# print(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}))



