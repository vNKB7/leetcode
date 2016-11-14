#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
#可以很简单地使用递归遍历全树。但这里可以偷懒一点，使用上一题的代码稍加修改。
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0

        depth = 0
        queue = []
        queue.append(root)

        while len(queue) > 0:
            newQueue = []
            for node in queue:
                if node.left is not None:
                    newQueue.append(node.left)
                if node.right is not None:
                    newQueue.append(node.right)

            queue = newQueue
            depth += 1
        return depth - 1

s = Solution()

a = TreeNode(1)
b = TreeNode(2)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(5)
f = TreeNode(6)
a.left = b
a.right = c
b.left = d
b.right = f
c.right = e
print(s.maxDepth(a))





