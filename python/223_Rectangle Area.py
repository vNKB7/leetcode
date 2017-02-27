#!/usr/bin/env python2

class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """

        # 没有相交的情况
        if C <= E or G <= A or H <= B or D <= F:
            return (C - A) * (D - B) + (G - E) * (H - F)

        # 相交的情况
        left = max(A, E)
        right = min(C, G)
        top = min(D, H)
        bottom = max(B, F)

        return (C - A) * (D - B) + (G - E) * (H - F) - (top - bottom) * (right - left)