#!/usr/bin/env python3


# Solution 1. 查找速度太慢了，O(n)。
'''
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """

        self.capacity = capacity
        self.size = 0
        self.buffer = []


    def get(self, key):
        """
        :rtype: int
        """
        index = -1
        value = -1
        for i in range(len(self.buffer)):
            t = self.buffer[i]
            if t[0] == key:
                index = i
                value = t[1]
                break

        if index != -1:
            t = self.buffer.pop(index)
            self.buffer.append(t)

        return value

    def getIndex(self, key):
        for i in range(len(self.buffer)):
            t = self.buffer[i]
            if t[0] == key:
                return i
        return -1

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """

        index = self.getIndex(key)
        if index != -1:
            self.buffer.pop(index)
            self.buffer.append([key, value])
        else:
            if self.size == self.capacity:
                self.buffer.pop(0)
                self.buffer.append([key, value])
            else:
                self.buffer.append([key, value])
                self.size += 1
'''

# Solution 2. 搜索为O(lgn)
# 看答案好像直接用引用会快很多。。。以及用双向链表加快增删

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """

        self.capacity = capacity
        self.size = 0
        self.buffer = {}
        self.window = []
        self.time = 0


    def get(self, key):
        """
        :rtype: int
        """

        if key in self.buffer:
            value, ts = self.buffer[key]
            index = self.searchWindow(ts)
            self.window.pop(index)
            self.time += 1
            self.window.append([self.time, key])
            self.buffer[key] = [value, self.time]
            return value
        else:
            return -1

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """

        if key in self.buffer:
            ts = self.buffer[key][1]
            index = self.searchWindow(ts)
            self.window.pop(index)
            self.time += 1
            self.window.append([self.time, key])
            self.buffer[key] = [value, self.time]
        else:
            if self.size < self.capacity:
                self.time += 1
                self.window.append([self.time, key])
                self.buffer[key] = [value, self.time]
                self.size += 1
            else:
                leastRecent = self.window.pop(0)
                self.buffer.pop(leastRecent[1])
                self.time += 1
                self.buffer[key] = [value, self.time]
                self.window.append([self.time, key])


    def searchWindow(self, ts):
        start = 0
        end = len(self.window)
        while start < end:
            mid = (end + start) // 2
            if self.window[mid][0] == ts:
                return mid
            elif self.window[mid][0] > ts:
                end = mid
            else:
                start = mid + 1
        return -1


l = LRUCache(2)
l.set(2,1)
l.set(1,1)
print(l.buffer)
print(l.get(2))
l.set(4,1)
print(l.buffer)
print(l.get(1))
print(l.get(2))



