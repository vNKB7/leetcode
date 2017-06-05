package brand_new;

public class _287_Find_the_Duplicate_Number {
	public int findDuplicate(int[] nums) {
		int fast = nums.length - 1;
		int slow = fast;
		do {
			slow = nums[slow] - 1;
			fast = nums[nums[fast] - 1] - 1;
		} while (nums[fast] != nums[slow]);

		int p = nums.length - 1;
		while(nums[p] != nums[slow]){
			p = nums[p]-1;
			slow = nums[slow]-1;
		}
		return nums[slow];
	}

	public static void main(String[] args) {
		System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[]{2,1,1,1,4}));
	}

}
