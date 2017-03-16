package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (j < k) {
				if (nums[j] + nums[k] == -nums[i]) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < --k && nums[k] == nums[k + 1]) {
					}
					while (++j < k && nums[j] == nums[j - 1]) {
					}

				} else if (nums[j] + nums[k] > -nums[i]) {
					k--;
				} else {
					j++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new _15_3Sum().threeSum(new int[] {0,0,0 });
		for (List<Integer> l : result) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
