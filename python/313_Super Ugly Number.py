#!/usr/bin/env python2
#coding=utf-8

class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        length = len(primes)
        queue = [1]
        count = [0] * length

        for i in range(n-1):
            temp = min([primes[x] * queue[count[x]] for x in range(length)])
            queue.append(temp)
            for k in range(length):
                if primes[k] * queue[count[k]] == temp:
                    count[k] += 1

        return queue[-1]

s = Solution()

print [s.nthSuperUglyNumber(i,[2, 7, 13, 19]) for i in range(10)]