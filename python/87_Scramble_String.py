#!/usr/bin/env python3

class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if s1 is None or s2 is None or len(s1) != len(s2):
            return False

        self.memory = {}

        return self.helper(s1, s2)


    def helper(self, s1, s2):#this method is bad
        if s1 == s2:
            return True

        if s1 + s2 in self.memory:
            return self.memory[s1+s2]

        for i in range(1, len(s1)):
            if self.helper(s1[:i], s2[:i]) and self.helper(s1[i:], s2[i:]) or self.helper(s1[:i], s2[-i:]) and self.helper(s1[i:], s2[:-i]):
                self.memory[s1+s2] = True
                return True

        self.memory[s1+s2] = False
        return False

s = Solution()
print(s.isScramble('abcd', 'bdac'))