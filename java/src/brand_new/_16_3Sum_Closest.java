package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16_3Sum_Closest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;// ?
		}
		int closest = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (j < k) {
				if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math
						.abs(closest - target)) {
					closest = nums[i] + nums[j] + nums[k];
					if (closest - target == 0) {
						return closest;
					}
				}

				if (nums[i] + nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}

		return closest;
	}

	public static void main(String[] args) {
		System.out.println(new _16_3Sum_Closest().threeSumClosest(new int[] {
				0,5,-1,-2,4,-1,0,-3,4,-5 }, 1));
	}
}
