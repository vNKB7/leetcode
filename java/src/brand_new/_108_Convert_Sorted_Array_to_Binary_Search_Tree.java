package brand_new;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
		if (i >= j)
			return null;
		if (j - i == 1)
			return new TreeNode(nums[i]);

		int mid = (i + j) / 2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = sortedArrayToBST(nums, i, mid);
		head.right = sortedArrayToBST(nums, mid + 1, j);
		return head;
	}
}
