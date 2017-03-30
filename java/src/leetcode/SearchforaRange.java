package leetcode;

public class SearchforaRange {

	public int[] searchRange(int[] nums, int target) {
		int[] range = new int[2];
		if (nums.length == 0) {
			range[0] = -1;
			range[1] = -1;
			return range;
		}
		int index = binarySearch(0, nums.length - 1, nums, target);

		if (index == -1) {
			range[0] = -1;
			range[1] = -1;
		} else {
			int start = 0;
			for (start = index - 1; start >= 0; start--) {
				if (nums[start] != target) {
					break;
				}
			}

			if (start == 0 && nums[start] == target) {
				range[0] = 0;
			} else {
				range[0] = start + 1;
			}

			int end = 0;
			for (end = index + 1; end < nums.length; end++) {
				if (nums[end] != target) {
					break;
				}
			}

			if (end == nums.length - 1 && nums[end] == target) {
				range[1] = end;
			} else {
				range[1] = end - 1;
			}
		}

		return range;
	}

	int binarySearch(int start, int end, int[] nums, int target) {
		if (nums[start] == target) {
			return start;
		}

		if (nums[end] == target) {
			return end;
		}

		if (nums[start] < target && nums[end] > target) {
			if (end - start < 10) {
				for (int i = start + 1; i < end; i++) {
					if (nums[i] == target) {
						return i;
					}
				}
			} else {
				int index = -1;

				index = binarySearch(start + 1, (start + end) / 2, nums, target);
				if (index != -1) {
					return index;
				}

				index = binarySearch((start + end) / 2 + 1, end - 1, nums,
						target);
				if (index != -1) {
					return index;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
