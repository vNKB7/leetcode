package brand_new;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int pi, int pj,
			int qi, int qj) {
		if (pi == pj) {
			return new TreeNode(preorder[pi]);
		} else {
			int i = qi;
			for (; i <= qj; i++) {
				if (preorder[pi] == inorder[i])
					break;
			}
			int j = i-qi+pi+1;
			TreeNode head = new TreeNode(preorder[pi]);

			if (i == qi) {
				head.right = buildTree(preorder, inorder, pi + 1, pj, qi + 1,
						qj);
			} else if (i == qj) {
				head.left = buildTree(preorder, inorder, pi + 1, pj, qi, qj - 1);
			} else {
				head.left = buildTree(preorder, inorder, pi+1, j-1, qi, i-1);
				head.right = buildTree(preorder, inorder, j, pj, i+1, qj);
			}

			return head;
		}
	}

}
