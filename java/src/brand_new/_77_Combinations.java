package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<Integer>(), n, 0, k);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> prefix,
			int n, int index, int remain) {
		if (remain == 0) {
			result.add(new ArrayList<Integer>(prefix));
		} else if (index == n)
			return;

		for (int i = index; i < n; i++) {
			prefix.add(i + 1);
			backtrack(result, prefix, n, i + 1, remain - 1);
			prefix.remove(prefix.size() - 1);
		}
	}
}
