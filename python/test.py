#!/usr/bin/env python


a = 1
b = 2
c = 3
a,b,c = b,c,a
print a,b,c

a = [1]
b = [2]
c = [3]
a,b,c = b,c,a
print a,b,c

class Node(object):
    def __init__(self,x):
        self.val = x

a = Node(1)
b = Node(2)
c = Node(3)
a,b,c = b,c,a
print a.val,b.val,c.val

a = Node(1)
b = Node(2)
c = Node(3)
a,a,c = b,c,a
print a.val,b.val,c.val