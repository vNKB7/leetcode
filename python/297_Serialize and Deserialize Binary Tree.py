#!/usr/bin/env python2

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''

        queue = [root]
        data = []
        while queue:
            cur = queue.pop(0)
            if not cur:
                data.append('None')
            else:
                data.append(str(cur.val))
                queue.append(cur.left)
                queue.append(cur.right)
        while data[-1] == 'None':
            data.pop(-1)
        return ','.join(data)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        vals = data.split(',')
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


# Your Codec object will be instantiated and called as such:
codec = Codec()
root = codec.deserialize('')
codec.deserialize(codec.serialize(None))
