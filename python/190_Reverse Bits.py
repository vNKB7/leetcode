#!/usr/bin/env python3

class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        div = n
        result = 0
        for i in range(32):
            div, mod = divmod(div, 2)
            result = result * 2 + mod

        return result

s = Solution()
print(s.reverseBits(43261596))