package brand_new;

public class _81_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] == nums[lo] && nums[lo] == nums[hi - 1]) {
				lo++;
				hi--;
			} else if (nums[mid] <= nums[hi - 1]){
				if(nums[mid] < target && target <= nums[hi - 1]) 
					lo = mid + 1;
				else
					hi = mid;
			} else {
				if(nums[lo] <= target && target < nums[mid])
					hi = mid;
				else
					lo = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		System.out.println(new _81_Search_in_Rotated_Sorted_Array_II().search(
				nums, 3));
	}

}
