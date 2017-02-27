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

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if not root:
            return []
        output = []
        result = self.help(root)
        for r in result:
            output.append('->'.join(r[::-1]))
        return output


    def help(self, root):
        result = []
        if not root.left and not root.right:
            return [[str(root.val)]]

        if root.left:
            result.extend(self.help(root.left))
        if root.right:
            result.extend(self.help(root.right))
        for l in result:
            l.append(str(root.val))
        return result


root = build([1,2,3,None,5])
s = Solution()
print s.binaryTreePaths(root)

