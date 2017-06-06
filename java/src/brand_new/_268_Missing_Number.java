package brand_new;

public class _268_Missing_Number {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {

			while (nums[i] != i) {
				if (nums[i] == n)
					break;
				swap(nums, i, nums[i]);
			}
		}

		for (int i = 0; i < n; i++) {
			if (i != nums[i])
				return i;
		}

		return n;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
