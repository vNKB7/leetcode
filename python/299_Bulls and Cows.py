#!/usr/bin/env python2

class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        count = {}
        remain = []
        A = 0
        B = 0
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                A += 1
            else:
                if secret[i] not in count:
                    count[secret[i]] = 0
                count[secret[i]] += 1
                remain.append(guess[i])

        for c in remain:
            if c in count and count[c] > 0:
                B += 1
                count[c] -= 1

        return '%dA%dB' % (A, B)

