package brand_new;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _84_Largest_Rectangle_in_Histogram {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		int[][] heightsIndex = new int[heights.length][2];
		for (int i = 0; i < heights.length; i++) {
			heightsIndex[i][0] = heights[i];
			heightsIndex[i][1] = i;
		}

		Arrays.sort(heightsIndex, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int max = 0;
		
		int lastVal = -1;
		Set<Integer> addIndex = new HashSet<>();

		for (int i = 0; i < heightsIndex.length; i++) {
			int val = heightsIndex[i][0];
			int index = heightsIndex[i][1];
			int left = -1, right = heights.length;
			
			/*
			 * 其实不需要以值为轮次添加tm。
			 * 因为可以通过简单的证明得到不会有影响。
			 * 这样做可以达到nlog(n)。
			 * 其实也可以用分治法所，也是nlog(n)。
			 */
			
			if(lastVal != -1 && lastVal != val){
				for(int idx : addIndex){
					tm.put(idx, lastVal);
				}
				addIndex = new HashSet<>();
			}
			lastVal = val;
			addIndex.add(index);

			Map.Entry<Integer, Integer> leftEty = tm.lowerEntry(index);
			if (leftEty != null) {
				left = leftEty.getKey();
			}

			Map.Entry<Integer, Integer> rightEty = tm.higherEntry(index);
			if (rightEty != null) {
				right = rightEty.getKey();
			}

			max = Math.max(max, val * (right - left - 1));
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new _84_Largest_Rectangle_in_Histogram()
				.largestRectangleArea(new int[] { 0, 2, 0 }));
	}

}
