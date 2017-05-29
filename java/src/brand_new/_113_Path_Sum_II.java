package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _113_Path_Sum_II {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		pathSum(result, root, sum, new ArrayList<Integer>());
		return result;
	}

	public void pathSum(List<List<Integer>> result, TreeNode root, int sum,
			List<Integer> prefix) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && sum == root.val) {
			prefix.add(root.val);
			result.add(new ArrayList<Integer>(prefix));
			prefix.remove(prefix.size() - 1);
		} else {
			prefix.add(root.val);
			if (root.left != null)
				pathSum(result, root.left, sum - root.val, prefix);
			if (root.right != null)
				pathSum(result, root.right, sum - root.val, prefix);

			prefix.remove(prefix.size() - 1);
		}
	}
}
