#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        stack = []
        cur = root
        result = []

        while cur or len(stack) > 0:
            if not cur:
                curT = stack[-1]
                if curT[1] == 2:
                    curT[1] = 1
                    cur = curT[0].right
                else:
                    stack.pop(-1)
                    result.append(curT[0].val)
                    cur = None
            else:
                stack.append([cur, 2])
                cur = cur.left

        return result

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

s = Solution()
root = build([1,2])
print(s.postorderTraversal(root))