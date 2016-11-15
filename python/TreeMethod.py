#!/usr/bin/env python3

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def build(vals):
    if vals is None or len(vals) == 0:
        return None

    queue = []
    root = TreeNode(vals[0])
    queue.append(root)
    i = 1

    while len(queue) > 0:
        cur = queue.pop(0)
        if i < len(vals) and vals[i] is not None:
            cur.left = TreeNode(vals[i])
            queue.append(cur.left)
        if i+1 < len(vals) and vals[i+1] is not None:
            cur.right = TreeNode(vals[i+1])
            queue.append(cur.right)
        i += 2

    return root

def show(root):
    if root is None:
        return None

    queue = []
    queue.append(root)
    vals = [root.val]

    while len(queue) > 0:
        cur = queue.pop(0)

        if cur.left is None:
            vals.append(None)
        else:
            vals.append(cur.left.val)
            queue.append(cur.left)

        if cur.right is None:
            vals.append(None)
        else:
            vals.append(cur.right.val)
            queue.append(cur.right)

    while vals[-1] is None:
        vals.pop()
    return vals

if __name__ == '__main__':
    root = build([1,2,3,None,4,5,None,6,7,8])
    print(show(root))

