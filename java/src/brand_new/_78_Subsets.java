package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			copyList(result, nums[i]);
		}
		return result;
	}

	public void copyList(List<List<Integer>> list, int num) {
		int n = list.size();
		for (int i = 0; i < n; i++) {
			List<Integer> new_list = new ArrayList<Integer>(list.get(i));
			new_list.add(num);
			list.add(new_list);
		}
	}
}
