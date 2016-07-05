package leetcode;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		return binarySearch(0, nums.length - 1, nums, target);
	}

	int binarySearch(int start, int end, int[] nums, int target) {
		if (nums[start] == target) {
			return start;
		}

		if (nums[end] == target) {
			return end;
		}

		if (end - start < 10) {
			if (nums[start] > target) {
				return start;
			}

			if (nums[end] < target) {
				return end + 1;
			}

			for (int i = start; i <= end; i++) {
				if (nums[i] >= target) {
					return i;
				}
			}
			return end;
		} else {
			int mid_s = (end + start) / 2 + 1;
			int mid_e = (end + start) / 2;

			if (nums[mid_e] < target && nums[mid_s] > target) {
				return mid_e;
			} else if (nums[mid_e] >= target) {
				return binarySearch(start, mid_e, nums, target);
			} else {
				return binarySearch(mid_s, end, nums, target);
			}
		}
	}

	public static void main(String[] args) {
		int[] range = { 1, 3 };

		System.out.println(new SearchInsertPosition().searchInsert(range, 2));

	}

}
