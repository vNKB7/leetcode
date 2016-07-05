package leetcode;

public class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null)
			return -1;

		if (nums[0] == target)
			return 0;
		if (nums[nums.length - 1] == target)
			return nums.length - 1;

		return binarySearch(0, nums.length - 1, nums, target);
	}

	int binarySearch(int start, int end, int[] nums, int target) {
		if (end - start < 10) {
			for (int i = start; i <= end; i++) {
				if (target == nums[i]) {
					return i;
				}
			}
			return -1;
		}

		if (nums[start] < nums[end]) {
			if (nums[start] < target && nums[end] > target) {
				if (nums[(start + end) / 2] == target) {
					return (start + end) / 2;
				} else if (nums[(start + end) / 2 + 1] == target) {
					return (start + end) / 2 + 1;
				} else {
					int result = 0;
					result = binarySearch(start, (start + end) / 2, nums,
							target);
					if (result != -1) {
						return result;
					}
					result = binarySearch((start + end) / 2 + 1, end, nums,
							target);
					if (result != -1) {
						return result;
					}
				}
			}
		} else if (target < nums[start] && target > nums[end]) {
			return -1;
		} else {
			if (nums[(start + end) / 2] == target) {
				return (start + end) / 2;
			} else if (nums[(start + end) / 2 + 1] == target) {
				return (start + end) / 2 + 1;
			} else {
				int result = 0;
				result = binarySearch(start, (start + end) / 2, nums, target);
				if (result != -1) {
					return result;
				}
				result = binarySearch((start + end) / 2 + 1, end, nums, target);
				if (result != -1) {
					return result;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new SearchinRotatedSortedArray().search(new int[]{1}, 0));

	}

}
