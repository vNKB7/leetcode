package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		int index = 0;
		while (index < nums.length) {
			int cur = nums[index];
			int nextIndex = index + 1;
			while (nextIndex < nums.length) {
				if (cur != nums[nextIndex])
					break;
				nextIndex++;
			}
			int range = nextIndex - index;
			int preSize = result.size();
			ArrayList<Integer> addItem = new ArrayList<>();
			for (int i = 0; i < range; i++) {
				addItem.add(cur);
				for (int j = 0; j < preSize; j++) {
					ArrayList<Integer> newItem = new ArrayList<Integer>(
							result.get(j));
					newItem.addAll(new ArrayList<Integer>(addItem));
					result.add(newItem);
				}
			}
			index = nextIndex;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _90_Subsets_II().subsetsWithDup(new int[]{1,2,2}));

	}

}
