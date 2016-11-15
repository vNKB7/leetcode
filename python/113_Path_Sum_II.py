#!/usr/bin/env python3
import TreeMethod


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        result = self.helper(root, sum, [])
        return result if result is not None else []

    def helper(self, root, sum, curList):
        if root is None:
            if not sum:
                return [curList]
            else:
                return None

        if root.left is None and root.right is not None:
            curList.append(root.val)
            return self.helper(root.right, sum - root.val, curList)
        elif root.right is None and root.left is not None:
            curList.append(root.val)
            return self.helper(root.left, sum - root.val, curList)

        if root.left is None and root.right is None:
            if sum - root.val == 0:
                curList.append(root.val)
                return [curList]
            else:
                return None

        tmpList = curList[:]
        curList.append(root.val)
        tmpList.append(root.val)
        result1 = self.helper(root.left, sum - root.val, curList)
        result2 = self.helper(root.right, sum - root.val, tmpList)
        if result1 is None and result2 is None:
            return None
        elif result1 is not None and result2 is not None:
            result1.extend(result2)
            return result1
        elif result1 is not None:
            return result1
        else:
            return result2





root = TreeMethod.build([5,4,8,11,None,13,4,7,2,None,None,5,1])
s = Solution()
print(s.pathSum(root, 22))

