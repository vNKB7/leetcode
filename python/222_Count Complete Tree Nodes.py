#!/usr/bin/env python2

# Definition for a binary tree node.
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

'''
class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0


        depth = 0
        cur = root
        while cur.left:
            cur = cur.left
            depth += 1

        count = 2 ** depth - 1
        stack = []
        cur = root
        curDep = 0
        while cur or len(stack) > 0:
            if not cur:
                cur, curDep = stack.pop(-1)
                if curDep == depth:
                    count += 1
                elif curDep == depth - 1 and not cur.left:
                    return count
                cur = cur.right
                curDep += 1
            else:
                stack.append((cur, curDep))
                curDep += 1
                cur = cur.left

        return count
'''

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0


        depth = 0
        cur = root
        while cur.left:
            cur = cur.left
            depth += 1

        count = 2 ** depth - 1

        queue = []
        queue.append((root, 0))
        while len(queue) > 0:
            cur, curDep = queue.pop(0)
            if curDep == depth:
                count += 1
            if cur.left:
                queue.append((cur.left, curDep+1))
            if cur.right:
                queue.append((cur.right, curDep+1))

        return count

root = build([1,2,3,4,5])
s = Solution()
print s.countNodes(root)