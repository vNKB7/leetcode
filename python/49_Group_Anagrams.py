#!/usr/bin/env python3

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        result = []#不需要额外的list来存结果,参考下面的程序
        anagramDict = {}
        index = 0

        for str in strs:
            strTuple = tuple(sorted(list(str)))
            if strTuple in anagramDict:
                result[anagramDict[strTuple]].append(str)#直接写在dict中
            else:
                result.append([])
                result[index].append(str)
                anagramDict[strTuple] = index
                index += 1

        return result
'''
#别人的代码。写得好。
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        # hashtale {(a, b, c): ["abc", "bca"]}
        #
        mp = {}
        for s in strs:
            lst = list(s); lst.sort(); lst = tuple(lst)
            if mp.get(lst):
                mp[lst].append(s)
            else:
                mp[lst] = [s]
        return mp.values()
'''

s = Solution()
print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
