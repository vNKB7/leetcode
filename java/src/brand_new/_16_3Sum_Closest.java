package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16_3Sum_Closest {

	// public int threeSumClosest(int[] nums, int target) {
	// if (nums == null || nums.length < 3) {
	// return 0;// ?
	// }
	// int closest = nums[0] + nums[1] + nums[2];
	// Arrays.sort(nums);
	//
	// for (int i = 0; i < nums.length - 2; i++) {
	// int j = i + 1, k = nums.length - 1;
	//
	// if (i > 0 && nums[i] == nums[i - 1]) {
	// continue;
	// }
	// while (j < k) {
	// if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math
	// .abs(closest - target)) {
	// closest = nums[i] + nums[j] + nums[k];
	// if (closest - target == 0) {
	// return closest;
	// }
	// }
	//
	// if (nums[i] + nums[j] + nums[k] > target) {
	// k--;
	// } else {
	// j++;
	// }
	// }
	// }
	//
	// return closest;
	// }

	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int closest = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int res = target - (nums[i] + nums[l] + nums[r]);
				if (Math.abs(res) < min) {
					min = Math.abs(res);
					closest = nums[i] + nums[l] + nums[r];
				}

				if (res == 0) {
					return target;
				} else if (res < 0) {
					r--;
				} else {
					l++;
				}
			}
		}

		return closest;
	}

	public static void main(String[] args) {
		System.out.println(new _16_3Sum_Closest().threeSumClosest(new int[] {
				0, 2, 1, -3 }, 1));
	}
}
