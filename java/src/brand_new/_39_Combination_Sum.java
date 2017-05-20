package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_Combination_Sum {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		if (candidates.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<Integer> prefix = new ArrayList<Integer>();
		help(candidates, 0, prefix, target);
		return result;
	}

	public void help(int[] candidates, int can_index, List<Integer> prefix,
			int target) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(prefix));
		} else {
			for (int c = can_index; c < candidates.length; c++) {
				if (candidates[c] <= target) {
					prefix.add(candidates[c]);
					help(candidates, c, prefix, target - candidates[c]);
					prefix.remove(prefix.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new _39_Combination_Sum().combinationSum(
				new int[] { 92, 71, 89, 74, 102, 91, 70, 119, 86, 116, 114,
						106, 80, 81, 115, 99, 117, 93, 76, 77, 111, 110, 75,
						104, 95, 112, 94, 73 }, 310);
		for (List<Integer> i : result) {
			System.out.println(i);
		}
	}
}
