#!/usr/bin/env python3

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

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return max(self.helper(root))

    def helper(self, root):
        leftChild = rightChild = leftMax = rightMax = -1000
        if root.left:
            leftChild, leftMax = self.helper(root.left)
        if root.right:
            rightChild, rightMax = self.helper(root.right)

        return (max(leftChild, rightChild, 0) + root.val, max(leftChild + rightChild + root.val, leftMax, rightMax, leftChild, rightChild))



root = build([-6, None, 3, 2])
s = Solution()
print(s.maxPathSum(root))

