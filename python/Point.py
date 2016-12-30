#!/usr/bin/env python3

class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

def printPoint(point):
    print('%f, %f\n' % (point.x, point.y))