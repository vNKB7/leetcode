package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);

		findSubSolution(result, candidates, target, 0,
				new ArrayList<Integer>(), new int[candidates.length], 0);

		return result;
	}

	void findSubSolution(List<List<Integer>> list, int[] candidates,
			int target, int index, List<Integer> pre, int[] chosen, int preSum) {
		for (int i = index; i < candidates.length; i++) {
			if (i - 1 >= 0
					&& candidates[i] == candidates[i - 1]
					&& (pre.size() - 1 < 0 || pre.size() - 1 >= 0
							&& chosen[i-1] == 0))
				continue;
			if (preSum + candidates[i] == target) {
				pre.add(candidates[i]);
				list.add(new ArrayList<Integer>(pre));
				pre.remove(pre.size() - 1);
			} else if (preSum + candidates[i] < target) {
				pre.add(candidates[i]);
				chosen[i] = 1;
				findSubSolution(list, candidates, target, i + 1, pre, chosen, preSum
						+ candidates[i]);
				pre.remove(pre.size() - 1);
				chosen[i] = 0;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new CombinationSumII().combinationSum2(
				new int[] { 2,2,2,2,2 }, 4);

		for (int i = 0; i < result.size(); i++) {
			List<Integer> tmp = result.get(i);

			for (int j = 0; j < tmp.size(); j++) {
				System.out.print(tmp.get(j) + " ");
			}
			System.out.println();
		}
	}

}
