package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _228_Summary_Ranges {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		int first = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] + 1 != nums[i]) {
				if (first + 1 == i) {
					result.add(nums[first] + "");
				} else {
					result.add(nums[first] + "->" + nums[i - 1]);
				}
				first = i;
			}
		}

		if (first + 1 == nums.length) {
			result.add(nums[first] + "");
		} else {
			result.add(nums[first] + "->" + nums[nums.length - 1]);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
