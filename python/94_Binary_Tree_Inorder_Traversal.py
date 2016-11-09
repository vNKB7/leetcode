#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # def inorderTraversal(self, root):
    #     """
    #     :type root: TreeNode
    #     :rtype: List[int]
    #     """
    #     if root is None:
    #         return []
    #
    #     result = []
    #     queue = []
    #
    #     cur = root
    #
    #     while len(queue) > 0 or cur is not None:
    #         if cur is None and len(queue) > 0:
    #             cur = queue.pop()
    #             result.append(cur.val)
    #             cur = cur.right
    #         else:
    #             queue.append(cur)
    #             cur = cur.left
    #
    #     return result

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        if root is None:
            return []

        cur = root
        queue = []
        result = []

        while cur is not None or len(queue) > 0:
            while cur is not None:
                queue.append(cur)
                cur = cur.left

            cur = queue.pop()
            result.append(cur.val)

            # if cur.right is not None:
            cur = cur.right

        return result






s = Solution()


a = TreeNode('a')
b = TreeNode('b')
c = TreeNode('c')
a.right = b
b.left = c

# a = TreeNode('a')
# b = TreeNode('b')
# a.left = b

print(s.inorderTraversal(a))
