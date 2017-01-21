#!/usr/bin/env python2
# coding: utf-8

class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        if not buildings or not len(buildings):
            return []

        position = {}
        pos_point = set()
        length = len(buildings)
        for i in range(length):
            li, ri, hi = buildings[i]
            if li not in position:
                position[li] = [[],[]]
            position[li][0].append(i)

            if ri not in position:
                position[ri] = [[],[]]
            position[ri][1].append(i)

            pos_point.add(li)
            pos_point.add(ri)

        pos_point = sorted(list(pos_point))
        key_point = []
        cur_height = 0
        cur_building = -1
        buildings_list = set()
        for p in range(len(pos_point)):
            i = pos_point[p]
            left, right = position[i]
            buildings_list |= set(left)
            buildings_list -= set(right)

            if len(left):
                max_height, max_index = max((buildings[x][2], x) for x in left)
                if max_height > cur_height:
                    cur_building = max_index
                    cur_height = max_height
                    key_point.append([i, cur_height])

            if cur_building in right:
                if not len(buildings_list):
                    cur_building = -1
                    cur_height = 0
                    key_point.append([i, 0])
                else:
                    max_height, max_index = max((buildings[x][2], x) for x in buildings_list)
                    cur_building = max_index
                    if max_height != cur_height:
                        cur_height = max_height
                        key_point.append([i, cur_height])

        return key_point

s = Solution()
print s.getSkyline([ [2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8] ] )


