#!/usr/bin/env python3
class WBTreeNode(object):
    def __init__(self, x):
        self.val = x
        self.children = []


# 不知道为什么不行啊
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        if not s or len(s) == 0 or not wordDict or len(wordDict) == 0:
            return []

        root = WBTreeNode('')
        nodeStore = {} # index:[treeNode]
        listStore = []

        count = 0

        maxMiss = max([len(x) for x in wordDict])

        for i in range(len(s)):
            if(self.wordBreakSub(s[:i+1], wordDict)):
                count = 0
            else:
                count += 1
            if count >= maxMiss:
                return []

        for i in range(len(s)):
            for k in listStore:
                v = nodeStore[k]
                str = s[k+1:i+1]
                if str in wordDict:
                    if i not in nodeStore:
                        nodeStore[i] = []
                    for node in v:
                        newNode = WBTreeNode(str)
                        node.children.append(newNode)
                        nodeStore[i].append(newNode)
            str = s[:i+1]
            if str in wordDict:
                newNode = WBTreeNode(str)
                if i not in nodeStore:
                        nodeStore[i] = []
                root.children.append(newNode)
                nodeStore[i].append(newNode)
            if i in nodeStore:
                listStore.append(i)

        if len(root.children) == 0:
            return []

        return self.helper(root, [], len(s))

    def wordBreakSub(self, s, wordDict):
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
                        break

        if not len(temp):
            return []
        else:
            return temp[-1] == len(s)-1

    def helper(self, node, preList, length):
        if len(node.children) == 0:
            preList.append(node.val)
            preList.pop(0)
            if len(''.join(preList)) == length:
                str = ' '.join(preList)
                return [str]
            else:
                return []
        else:
            result = []
            preList.append(node.val)
            for child in node.children:
                result.extend(self.helper(child, preList[:], length))
            return result

s = Solution()
print(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]))
