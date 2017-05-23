package brand_new;

public class _80_Remove_Duplicates_from_Sorted_Array_II {
	
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int pre = nums[0];
		int count = 1;
		int fast = 1, slow = 1;

		for(;fast < nums.length; fast++){
			if (nums[fast] == pre) {
				count++;
				if (count <= 2) {
					nums[slow] = nums[fast];
					slow++;
				}
			}else {
				count = 1;
				pre = nums[fast];
				nums[slow] = nums[fast];
				slow++;
			}
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,3,4,4,4};
		System.out.println(new _80_Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(nums));
		System.out.println();
	}

}
