package brand_new;

public class _129_Sum_Root_to_Leaf_Numbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode root, int prefix) {
		int sum = 0;
		prefix = prefix * 10 + root.val;
		if (root.left == null && root.right == null)
			return prefix;
		if (root.left != null)
			sum += sumNumbers(root.left, prefix);
		if (root.right != null)
			sum += sumNumbers(root.right, prefix);
		return sum;
	}
	
}
