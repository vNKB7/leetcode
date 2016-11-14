#!/usr/bin/env python3

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """

        if postorder is None or len(postorder) == 0:
            return None
        root = TreeNode(0)
        self.helper(inorder, postorder, 0, len(inorder), 0, len(postorder), root)
        return root

    def helper(self, inOrder, postorder, i_s, i_e, p_s, p_e, root):
        if i_s >= i_e:
            return
        if i_e - i_s == 1:
            root.val = inOrder[i_s]
            return

        print(i_s, i_e, p_s, p_e)
        root.val = postorder[p_e-1]
        offset = inOrder[i_s:i_e].index(postorder[p_e-1])
        i_s1 = i_s
        i_e1 = i_s + offset
        i_s2 = i_s + offset + 1
        i_e2 = i_e

        p_s1 = p_s
        p_e1 = p_s1 + i_e1 - i_s1
        p_s2 = p_e1
        p_e2 = p_s2 + i_e2 - i_s2


        if i_e1 - i_s1 > 0:
            root.left = TreeNode(0)
            self.helper(inOrder, postorder, i_s1, i_e1, p_s1, p_e1, root.left)

        if i_e2 - i_s2 > 0:
            root.right = TreeNode(0)
            self.helper(inOrder, postorder, i_s2, i_e2, p_s2, p_e2, root.right)



s = Solution()
s.buildTree([1, 3, 2], [3, 2, 1])