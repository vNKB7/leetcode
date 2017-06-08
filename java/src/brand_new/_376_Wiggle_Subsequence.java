package brand_new;

public class _376_Wiggle_Subsequence {

	// ver 1.0 O(n^2)
	// public int wiggleMaxLength(int[] nums) {
	// if(nums.length < 2)
	// return nums.length;
	//
	// int[] min = new int[nums.length];
	// int[] max = new int[nums.length];
	// int max_length = 1;
	// min[0] = max[0] = 1;
	// for (int i = 1; i < nums.length; i++) {
	// max[i] = min[i] = 1;
	// for (int j = 0; j < i; j++) {
	// if (nums[j] < nums[i] && min[j] + 1 > max[i])
	// max[i] = min[j] + 1;
	// else if (nums[i] < nums[j] && max[j] + 1 > min[i])
	// min[i] = max[j] + 1;
	// }
	// max_length = Math.max(Math.max(max[i], min[i]), max_length);
	// }
	// return max_length;
	// }

	// ver 2.0 O(n)
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		up[0] = down[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				up[i] = up[i - 1];
				down[i] = up[i - 1] + 1;
			} else {
				up[i] = up[i - 1];
				down[i] = down[i - 1];
			}
		}
		return Math.max(up[nums.length - 1], down[nums.length - 1]);
	}

	public static void main(String[] args) {
		System.out.println(new _376_Wiggle_Subsequence()
				.wiggleMaxLength(new int[] {1,3,2,4,5,7,5}));
	}

}
