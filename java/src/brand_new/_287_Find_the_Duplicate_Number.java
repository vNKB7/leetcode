package brand_new;

public class _287_Find_the_Duplicate_Number {
	public int findDuplicate(int[] nums) {
		int fast = nums.length - 1;
		int slow = fast;
		do {
			slow = nums[slow] - 1;
			fast = nums[nums[fast] - 1] - 1;
		} while (nums[fast] != nums[slow]);

		return nums[slow];
	}

	public static void main(String[] args) {
		
	}

}
