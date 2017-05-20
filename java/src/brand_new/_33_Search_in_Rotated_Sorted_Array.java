package brand_new;

public class _33_Search_in_Rotated_Sorted_Array {

	// public int search(int[] nums, int target) {
	// if (nums.length == 0)
	// return -1;
	// return search(nums, 0, nums.length - 1, target);
	// }
	//
	// public int search(int[] nums, int start, int end, int target) {
	// if(start > end){
	// return -1;
	// }
	// int mid = (start + end) / 2;
	// if (target < nums[start] && target > nums[end]) {
	// return -1;
	// } else {
	// if (nums[mid] == target) {
	// return mid;
	// }
	//
	// if (nums[start] <= nums[mid]) {
	// if (nums[start] <= target && target < nums[mid]) {
	// return search(nums, start, mid - 1, target);
	// } else {
	// return search(nums, mid + 1, end, target);
	// }
	// } else {
	// if (nums[mid] < target && target <= nums[end]) {
	// return search(nums, mid + 1, end, target);
	// } else {
	// return search(nums, start, mid - 1, target);
	// }
	// }
	// }
	// }

	public int search(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] == target){
				return mid;
			}
			
			if(nums[start] <= nums[mid]){
				if(nums[start] <= target && nums[mid] > target){
					end = mid - 1;
				}else{
					start = mid + 1;
				}
			}else{
				if(nums[mid] < target && nums[end] >= target){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		System.out.println(new _33_Search_in_Rotated_Sorted_Array().search(
				new int[] {3, 1}, 1));
	}
}
