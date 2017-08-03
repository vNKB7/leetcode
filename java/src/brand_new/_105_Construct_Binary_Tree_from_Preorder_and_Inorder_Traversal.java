package brand_new;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	// ver 1.0
	// public TreeNode buildTree(int[] preorder, int[] inorder) {
	// if (preorder.length == 0)
	// return null;
	// return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
	// inorder.length - 1);
	// }
	//
	// public TreeNode buildTree(int[] preorder, int[] inorder, int pi, int pj,
	// int qi, int qj) {
	// if (pi == pj) {
	// return new TreeNode(preorder[pi]);
	// } else {
	// int i = qi;
	// for (; i <= qj; i++) {
	// if (preorder[pi] == inorder[i])
	// break;
	// }
	// int j = i-qi+pi+1;
	// TreeNode head = new TreeNode(preorder[pi]);
	//
	// if (i == qi) {
	// head.right = buildTree(preorder, inorder, pi + 1, pj, qi + 1,
	// qj);
	// } else if (i == qj) {
	// head.left = buildTree(preorder, inorder, pi + 1, pj, qi, qj - 1);
	// } else {
	// head.left = buildTree(preorder, inorder, pi+1, j-1, qi, i-1);
	// head.right = buildTree(preorder, inorder, j, pj, i+1, qj);
	// }
	//
	// return head;
	// }
	// }

	
	// ver 2.0
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length || preorder.length == 0)
			return null;
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int pi, int pj,
			int qi, int qj) {
		if (pi == pj) {
			return new TreeNode(preorder[pi]);
		} else if (pi > pj) {
			return null;
		}

		int qhead = 0;
		for (int i = 0; i <= qj; i++) {
			if (inorder[i] == preorder[pi]) {
				qhead = i;
				break;
			}
		}

		int left_size = qhead - qi;
		TreeNode root = new TreeNode(preorder[pi]);
		root.left = buildTree(preorder, inorder, pi + 1, pi + left_size, qi,
				qhead - 1);
		root.right = buildTree(preorder, inorder, pi + left_size + 1, pj,
				qhead + 1, qj);
		return root;
	}
}
