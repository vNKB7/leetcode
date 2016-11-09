#!/usr/bin/env python3

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """

        length = len(s)
        if length > 12 or length < 4:
            return []

        tmpList = [['']]

        for i in range(length):
            newTmpList = []
            num = s[i]
            for ip in tmpList:
                if int(ip[-1] + num) <= 255:
                    if ip[-1] != '' and int(ip[-1]) == 0:
                       pass
                    else:
                        newIp = ip[:]
                        newIp[-1] += num
                        newTmpList.append(newIp)

                if len(ip) < 4 and len(ip[-1]) > 0:
                    newIp = ip[:]
                    newIp.append(num)
                    newTmpList.append(newIp)

            tmpList = newTmpList

        return ['.'.join(x) for x in tmpList if len(x) == 4]


s = Solution()
print(s.restoreIpAddresses("010010"))
