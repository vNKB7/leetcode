package brand_new;

import java.util.List;

public class _120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if (n == 0)
			return 0;
		int[] memory = new int[n];
		memory[0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				int a = j - 1 >= 0 ? memory[j - 1] : Integer.MAX_VALUE;
				int b = j == i ? Integer.MAX_VALUE : memory[j];
				memory[j] = (a < b ? a : b) + triangle.get(i).get(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (memory[i] < min)
				min = memory[i];
		}
		return min;
	}
}
