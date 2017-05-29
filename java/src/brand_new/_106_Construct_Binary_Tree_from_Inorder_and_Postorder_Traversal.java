package brand_new;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		return buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder, int pi, int pj,
			int qi, int qj) {
		if (pi >= pj)
			return null;
		else if(pj - pi == 1)
			return new TreeNode(inorder[pi]);
		
		int ph = 0;
		for(; ph < pj; ph++)
			if(inorder[ph] == postorder[qj-1])
				break;
		
		int offset = ph - pi;
		TreeNode head = new TreeNode(postorder[qj-1]);
		if(pi < ph)
			head.left = buildTree(inorder, postorder, pi, ph, qi, qi+offset);
		
		if(ph < pj-1)
			head.right = buildTree(inorder, postorder, ph+1, pj, qi+offset, qj-1);
		
		return head;
	}

	public static void main(String[] args) {
		new _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal().buildTree(new int[]{1,2,3,4}, new int[]{3,4,2,1});
	}

}
