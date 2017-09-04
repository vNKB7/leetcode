package brand_new;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 并不是正确解
 * 考虑将问题建模成图
 * 删除最少的节点使图中不存在边
 * 考虑贪心，每次删除度最大的节点，但这种想法不对
 */

public class _435_Non_overlapping_Intervals_2 {

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return 0;
		}

		Arrays.sort(intervals, (o1, o2) -> {
			return (o1.start == o2.start) ? (o1.end - o2.end)
					: (o1.start - o2.start);
		});

		int[][] endPoint = new int[intervals.length * 2][3];
		for (int i = 0; i < intervals.length; i++) {
			endPoint[i * 2][0] = intervals[i].start;
			endPoint[i * 2][1] = 1;
			endPoint[i * 2][2] = i;
			endPoint[i * 2 + 1][0] = intervals[i].end;
			endPoint[i * 2 + 1][1] = 2;
			endPoint[i * 2 + 1][2] = i;
		}

		Arrays.sort(endPoint, (o1, o2) -> {
			return (o1[0] == o2[0]) ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
		});

		Map<Integer, Set<Integer>> adj = new HashMap<>();
		Set<Integer> overlapSet = new HashSet<>();
		Set<Integer> removeSet = new HashSet<>();
		int lastpoint = -1;
		for (int[] point : endPoint) {
			if (point[1] == 1) {
				overlapSet.removeAll(removeSet);
				removeSet = new HashSet<>();
				lastpoint = -1;

				for (int ol : overlapSet) {
					if (!adj.containsKey(ol)) {
						adj.put(ol, new HashSet<>());
					}
					adj.get(ol).add(point[2]);
				}

				if (!adj.containsKey(point[2])) {
					adj.put(point[2], new HashSet<>());
				}
				adj.get(point[2]).addAll(overlapSet);

				overlapSet.add(point[2]);

			} else {
				if (point[0] != lastpoint) {
					overlapSet.removeAll(removeSet);
					removeSet = new HashSet<>();
				}
				// if (!adj.containsKey(point[2])) {
				// adj.put(point[2], new HashSet<>());
				// }
				// adj.get(point[2]).addAll(overlapSet);
				// overlapSet.remove(point[2]);
				removeSet.add(point[2]);
				lastpoint = point[0];
			}
		}

		int counts = 0;
		int[] degree = new int[intervals.length];
		for (Map.Entry<Integer, Set<Integer>> e : adj.entrySet()) {
			degree[e.getKey()] = e.getValue().size();
			// e.getValue().remove(e.getKey());
			counts += degree[e.getKey()];
		}

		int result = 0;
		while (counts > 0) {
			result++;
			int index = getMaxIndex(degree); // 策略不对
												// [[0,2],[1,3],[1,3],[2,4],[3,5],[3,5],[4,6]]
			counts -= degree[index] * 2;
			degree[index] = 0;
			for (int i : adj.get(index)) {
				degree[i]--;
			}
		}
		return result;
	}

	public int getMaxIndex(int[] array) {
		int max = array[0];
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int[] array = { 0, 2, 1, 3, 1, 3, 2, 4, 3, 5, 3, 5, 4, 6 };
		Interval[] intervals = new Interval[array.length / 2];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(array[i * 2], array[i * 2 + 1]);
		}

		System.out.println(new _435_Non_overlapping_Intervals_2()
				.eraseOverlapIntervals(intervals));
	}
}

// { 1, 2, 2, 3 }
// { 1, 2, 1, 2, 1, 2 }
// { 1, 2, 2, 3, 3, 4, 1, 3 }
// { 0, 2, 1, 3, 1, 3, 2, 4, 3, 5, 3, 5, 4, 6 }