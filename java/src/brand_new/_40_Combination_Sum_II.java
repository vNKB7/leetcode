package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
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
				if(c > can_index && candidates[c] == candidates[c-1])
					continue;
				if (candidates[c] <= target) {
					prefix.add(candidates[c]);
					help(candidates, c+1, prefix, target - candidates[c]);
					prefix.remove(prefix.size() - 1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> result = new _40_Combination_Sum_II().combinationSum2(
				new int[] { 10,1,2,7,6,1,5}, 8);
		for (List<Integer> i : result) {
			System.out.println(i);
		}
	}
}
