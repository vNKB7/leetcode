package brand_new;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
	public int findMin(int[] nums) {
		if (nums.length == 0)
			return 0;
		int start = 0, end = nums.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[start] <= nums[end-1])
				return nums[start];
			else if (nums[start] < nums[mid]) {
				start = mid + 1;
			} else {
				if(mid > 0 && nums[mid-1] > nums[mid]){
					return nums[mid];
				}
				end = mid;
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		System.out.println(new _153_Find_Minimum_in_Rotated_Sorted_Array().findMin(new int[]{5,1,2,3,4}));
	}

}
