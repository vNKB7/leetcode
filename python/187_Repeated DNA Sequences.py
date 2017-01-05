#!/usr/bin/env python3

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """

        result = []
        store = {}

        if len(s) <= 10:
            return []

        for i in range(len(s) - 9):
            string = s[i:i+10]
            if string in store:
                if store[string] == 1:
                    result.append(string)
                    store[string] += 1
            else:
                store[string] = 1

        return result

s = Solution()
print(s.findRepeatedDnaSequences("AAAAAAAAAAAAA"))