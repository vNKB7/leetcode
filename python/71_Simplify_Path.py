#!/usr/bin/env python3

class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """

        pathName = path.split('/')
        pathStack = []

        for name in pathName:
            if name == '' or name is None:
                continue
            elif name == '.':
                continue
            elif name == '..':
                if pathStack:
                    pathStack.pop()
            else:
                pathStack.append(name)

        return '/'+'/'.join(pathStack)

s = Solution()
print(s.simplifyPath('/home//foo/'))