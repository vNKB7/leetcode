#!/usr/bin/env python2

class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """

        square_list = []
        for i in range(1, n+1):
            if i * i <= n:
                square_list.append(i * i)
            else:
                break
        square_list.reverse()
        result = self.helper(square_list, 0, n, [], float('inf'), 0)
        return result

    def helper(self, square_list, index, remain, path, cur_min, cur_path_len):
        min_path = cur_min
        if cur_path_len + (remain / square_list[index]) > cur_min:
            return None
        for i in range(index, len(square_list)):
            if remain == square_list[i]:
                return len(path) + 1
            elif remain > square_list[i]:
                new_path = path[:]
                new_path.append(square_list[i])
                result = self.helper(square_list, i, remain - square_list[i], new_path, min_path, cur_path_len+1)
                if result is not None:
                    min_path = min(min_path, result)
        return min_path if min_path != float('inf') else None




s = Solution()
print s.numSquares(5778)