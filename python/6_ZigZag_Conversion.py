#!/usr/bin/env python

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        turnsNum = 2*numRows-2 if 2*numRows-2 > 0 else 1
        baseIndex = range(0, len(s), turnsNum)
        str = ''
        for i in range(numRows):
            if i == 0 or i == numRows - 1:
                for j in baseIndex:
                    if i+j < len(s):
                        str += s[i+j]
            else:
                for j in baseIndex:
                    if i+j < len(s):
                        str += s[i+j]
                    if 2*numRows-i-2+j < len(s):
                        str += s[2*numRows-i-2+j]
        return str


s = Solution()
print(s.convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd",4))


