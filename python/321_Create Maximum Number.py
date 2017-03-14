#!/usr/bin/env python2
#coding=utf8

'''
class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        k += 1
        m, n = len(nums1)+1, len(nums2)+1
        memory = [[[0] * n for _ in range(m)] for _ in range(k)]
        for h in range(k):
            for i in range(m):
                if m - i + n < k - h:
                    break
                for j in range(n):
                    if m-i+n-j < k-h:
                        break
                    else:
                        memory[h][i][j] = max((memory[h-1][i-1][j]*10+nums1[i-1]) if (h > 0 and i > 0) else 0, (memory[h-1][i][j-1]*10+nums2[j-1]) if (h > 0 and j > 0) else 0, (memory[h][i-1][j]) if i > 0 else 0, (memory[h][i][j-1]) if j > 0 else 0)
        max_num = memory[-1][-1][-1]
        result = []
        while max_num > 0:
            result.insert(0, max_num % 10)
            max_num /= 10
        return result
'''

'''
class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        nums1_list = [[0, []] for _ in range(10)]
        nums2_list = [[0, []] for _ in range(10)]

        for i, n in enumerate(nums1):
            nums1_list[n][0] += 1
            nums1_list[n][1].append(i)

        for i, n in enumerate(nums2):
            nums2_list[n][0] += 1
            nums2_list[n][1].append(i)

        max_num = 0

        for i in range(max(k-len(nums2), 0), min(k, len(nums1))+1):
            from_nums1 = i
            from_nums2 = k - i

            nums1_list_t = [[x, y[:]] for x, y in nums1_list]
            nums2_list_t = [[x, y[:]] for x, y in nums2_list]

            nums1_array = []
            while from_nums1 > 0:
                for j in range(10)[::-1]:
                    if nums1_list_t[j][0] > 0:
                        nums1_list_t[j][0] -= 1
                        nums1_array.append((j, nums1_list_t[j][1].pop()))
                        from_nums1 -= 1
                        break

            nums2_array = []
            while from_nums2 > 0:
                for j in range(10)[::-1]:
                    if nums2_list_t[j][0] > 0:
                        nums2_list_t[j][0] -= 1
                        nums2_array.append((j, nums2_list_t[j][1].pop()))
                        from_nums2 -= 1
                        break

            nums1_array = [x[0] for x in sorted(nums1_array, key=lambda x:x[1])]
            nums2_array = [x[0] for x in sorted(nums2_array, key=lambda x:x[1])]

            print nums1_array, nums2_array

            cur_num = 0
            while nums1_array or nums2_array:
                if not nums1_array:
                    cur_num = cur_num * 10 + nums2_array.pop(0)
                elif not nums2_array:
                    cur_num = cur_num * 10 + nums1_array.pop(0)
                elif nums1_array[0] > nums2_array[0]:
                    cur_num = cur_num * 10 + nums1_array.pop(0)
                else:
                    cur_num = cur_num * 10 + nums2_array.pop(0)
            if cur_num > max_num:
                max_num = cur_num
        return max_num
'''

class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """

        max_num = 0

        for i in range(max(k-len(nums2), 0), min(k, len(nums1))+1):
            drop1 = len(nums1) - i
            drop2 = len(nums2) - (k-i)
            # print drop1, drop2
            nums1_array = []
            for num in nums1:
                while drop1 and nums1_array and nums1_array[-1] < num:
                    nums1_array.pop()
                    drop1 -= 1
                nums1_array.append(num)
            nums1_array = nums1_array[:i]

            nums2_array = []
            for num in nums2:
                while drop2 and nums2_array and nums2_array[-1] < num:
                    nums2_array.pop()
                    drop2 -= 1
                nums2_array.append(num)
            nums2_array = nums2_array[:k-i]

            # print nums1_array, nums2_array

            cur_num = 0
            while nums1_array or nums2_array:
                if not nums1_array:
                    cur_num = cur_num * 10 + nums2_array.pop(0)
                elif not nums2_array:
                    cur_num = cur_num * 10 + nums1_array.pop(0)
                elif self.greater(nums1_array, nums2_array):
                    cur_num = cur_num * 10 + nums1_array.pop(0)
                else:
                    cur_num = cur_num * 10 + nums2_array.pop(0)
            if cur_num > max_num:
                max_num = cur_num

        result = []
        while max_num > 0:
            result.insert(0, max_num % 10)
            max_num /= 10
        return result

    def greater(self, nums1_array, nums2_array):
        if not nums1_array and not nums2_array:
            return True
        elif not nums1_array:
            return False
        elif not nums2_array:
            return True
        elif nums1_array[0] == nums2_array[0]:
            return self.greater(nums1_array[1:], nums2_array[1:])
        else:
            return nums1_array[0] > nums2_array[0]

s = Solution()
#print s.maxNumber([6,7],[6,0,4],5)
print s.maxNumber([6,4,7,8,6,5,5,3,1,7,4,9,9,5,9,6,1,7,1,3,6,3,0,8,2,1,8,0,0,7,3,9,3,1,3,7,5,9,4,3,5,8,1,9,5,6,5,7,8,6,6,2,0,9,7,1,2,1,7,0,6,8,5,8,1,6,1,5,8,4],[3,0,0,1,4,3,4,0,8,5,9,1,5,9,4,4,4,8,0,5,5,8,4,9,8,3,1,3,4,8,9,4,9,9,6,6,2,8,9,0,8,0,0,0,1,4,8,9,7,6,2,1,8,7,0,6,4,1,8,1,3,2,4,5,7,7,0,4,8,4],70)