package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);
		for (int l = 0; l < nums.length - 3; l++) {
			if (l > 0 && nums[l] == nums[l - 1]) {
				continue;
			}
			for (int i = l + 1; i < nums.length - 2; i++) {
				int j = i + 1, k = nums.length - 1;

				if (i > l+1 && nums[i] == nums[i - 1]) {
					continue;
				}
				while (j < k) {
					if (nums[j] + nums[k] + nums[i] + nums[l] == target) {
						result.add(Arrays.asList(nums[l], nums[i], nums[j], nums[k]));
						while (j < --k && nums[k] == nums[k + 1]) {
						}
						while (++j < k && nums[j] == nums[j - 1]) {
						}

					} else if (nums[j] + nums[k] + nums[i] + nums[l] > target) {
						k--;
					} else {
						j++;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new _18_4Sum().fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7);
		for (List<Integer> l : result) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}


	}

}
