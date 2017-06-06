package brand_new;

public class _337_House_Robber_III {
	public int rob(TreeNode root) {
		int[] result = help(root);
		return Math.max(result[0], result[1]);
	}

	public int[] help(TreeNode root) {
		int[] result = new int[2];// 0 : rob 1 : not rob

		if (root == null)
			return result;

		int[] left = help(root.left);
		int[] right = help(root.right);

		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
