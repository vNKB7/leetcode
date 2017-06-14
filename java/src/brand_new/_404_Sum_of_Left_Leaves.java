package brand_new;

public class _404_Sum_of_Left_Leaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		return helper(root.left, true) + helper(root.right, false);
	}

	public int helper(TreeNode root, boolean left) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			return left ? root.val : 0;
		} else {
			return helper(root.left, true) + helper(root.right, false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
