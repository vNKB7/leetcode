package leetcode;

public class SearchforaRange2 {

	public int[] searchRange(int[] nums, int target) {
		int[] range = binarySearch(0, nums.length - 1, nums, target);
		return range;
	}

	int[] binarySearch(int start, int end, int[] nums, int target) {
		if (nums[start] == target && nums[end] == target) {
			int[] range = { start, end };
			return range;
		}else if (end - start < 10) {
			int[] range = { -1, -1 };
			for (int i = start; i <= end; i++) {
				if (nums[i] == target && range[0] == -1) {
					range[0] = i;
				} else if (nums[i] != target && range[0] != -1) {
					range[1] = i - 1;
					break;
				}
			}
			if (nums[end] == target) {
				range[1] = end;
			}
			return range;
		} else {
			int mid = (start + end) / 2;
			if(nums[mid] == target && nums[mid+1] == target){
				int[] subRange1 = binarySearch(start, (start + end) / 2, nums,
						target);
				int[] subRange2 = binarySearch((start + end) / 2 + 1, end, nums,
						target);
				int[] range = { subRange1[0], subRange2[1]};
				return range;
			}else if(nums[mid] >= target){
				return binarySearch(start, (start + end) / 2, nums, target);
			}else{
				return binarySearch((start + end) / 2 + 1, end, nums, target);
			}
		}
		
	}

	public static void main(String[] args) {
		int[] range = { 0, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9,
				11, 11, 12, 12, 12 };
		range = new SearchforaRange2().searchRange(range, 6);
		System.out.println(range[0] + " " + range[1]);

	}

}
