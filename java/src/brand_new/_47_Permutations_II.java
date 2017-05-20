package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), new boolean[nums.length],
				nums);
		return list;
	}

	public void backtrack(List<List<Integer>> list, List<Integer> prefix,
			boolean[] bitmap, int[] nums) {
		if (nums.length == prefix.size()) {
			list.add(new ArrayList<Integer>(prefix));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!bitmap[i]
						&& (i == 0 || nums[i - 1] != nums[i] || bitmap[i - 1])) {
					bitmap[i] = true;
					prefix.add(nums[i]);
					backtrack(list, prefix, bitmap, nums);
					prefix.remove(prefix.size() - 1);
					bitmap[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
