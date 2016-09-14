#!/usr/bin/env python3

class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        words.append('')

        result = []

        wordsLen = len(words)
        index = 0
        curLen = 0
        start = 0

        while index < wordsLen:
            if curLen + len(words[index]) > maxWidth or index == wordsLen - 1:
                wordsNum = index - start
                spaceLen = maxWidth - curLen + wordsNum
                if index == wordsLen - 1:
                    curStr = ''
                    for i in range(wordsNum - 1):
                        curStr += words[start+i] + ' '
                    curStr += words[index - 1] + ' ' * (spaceLen - (wordsNum - 1))
                    result.append(curStr)
                elif wordsNum == 1:
                    result.append(words[start] + ' ' * (maxWidth - len(words[start])))
                else:
                    div, mod = divmod(spaceLen, wordsNum-1)
                    curStr = ''
                    for i in range(wordsNum - 1):
                        curStr += words[start+i] + ' ' * (div + (1 if mod > 0 else 0))
                        mod -= 1
                    curStr += words[index - 1]
                    result.append(curStr)
                curLen = 0
                start = index

            curLen += len(words[index]) + 1
            index += 1

        return result

s = Solution()
print(s.fullJustify(["Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."], 30))


