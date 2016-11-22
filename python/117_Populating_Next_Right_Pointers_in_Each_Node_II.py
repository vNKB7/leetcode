#!/usr/bin/env python3

# Definition for binary tree with next pointer.
class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

def build(vals):
    if vals is None or len(vals) == 0:
        return None

    queue = []
    root = TreeLinkNode(vals[0])
    queue.append(root)
    i = 1

    while len(queue) > 0:
        cur = queue.pop(0)
        if i < len(vals) and vals[i] is not None:
            cur.left = TreeLinkNode(vals[i])
            queue.append(cur.left)
        if i+1 < len(vals) and vals[i+1] is not None:
            cur.right = TreeLinkNode(vals[i+1])
            queue.append(cur.right)
        i += 2

    return root

def show(root):
    if root is None:
        return None

    queue = []
    queue.append(root)
    vals = [(root.val, root.next.val if root.next else None)]

    while len(queue) > 0:
        cur = queue.pop(0)

        if cur.left is None:
            vals.append(None)
        else:
            vals.append((cur.left.val, cur.left.next.val if cur.left.next else None))
            queue.append(cur.left)

        if cur.right is None:
            vals.append(None)
        else:
            vals.append((cur.right.val, cur.right.next.val if cur.right.next else None))
            queue.append(cur.right)

    while vals[-1] is None:
        vals.pop()
    return vals



class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if not root:
            return

        checkPoint = root

        while checkPoint:
            cur = checkPoint
            checkPoint = None

            while cur:
                if not checkPoint:
                    if cur.left:
                        checkPoint = cur.left
                        point = checkPoint
                    elif cur.right:
                        checkPoint = cur.right
                        point = checkPoint
                    else:
                        cur = cur.next
                else:
                    if cur.left and cur.left != checkPoint:
                        point.next = cur.left
                        point = cur.left
                    if cur.right and cur.right != checkPoint:
                        point.next = cur.right
                        point = point.next
                    cur = cur.next




s = Solution()
root = build([1,2,3])
s.connect(root)
print(show(root))