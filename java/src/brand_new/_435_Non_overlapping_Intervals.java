package brand_new;

import java.util.Arrays;
import java.util.TreeMap;

// 动态规划.求删除最少的区间,可以转化为最多有多少个区间不重叠

public class _435_Non_overlapping_Intervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1)
			return 0;

		Arrays.sort(intervals, (o1, o2) -> {
			return o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end;
		});

		TreeMap<Integer, Integer> tm = new TreeMap<>();

		for (int i = 0; i < intervals.length; i++) {
			Interval itv = intervals[i];
			// lower1/2 先求出key再求value.用了相同的变量
			Integer lower1 = tm.floorKey(itv.start);
			lower1 = (lower1 == null ? 0 : tm.get(lower1)) + 1;
			Integer lower2 = tm.floorKey(itv.end);
			lower2 = lower2 == null ? 0 : tm.get(lower2);
			tm.put(itv.end, Math.max(lower1, lower2));
		}

		return intervals.length - tm.get(intervals[intervals.length - 1].end);
	}

	public static void main(String[] args) {
		int[] array = { 0, 2, 1, 3, 1, 3, 2, 4, 3, 5, 3, 5, 4, 6 };
		Interval[] intervals = new Interval[array.length / 2];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(array[i * 2], array[i * 2 + 1]);
		}

		System.out.println(new _435_Non_overlapping_Intervals()
				.eraseOverlapIntervals(intervals));
	}
}

// { 1, 2, 2, 3 }
// { 1, 2, 1, 2, 1, 2 }
// { 1, 2, 2, 3, 3, 4, 1, 3 }
// { 0, 2, 1, 3, 1, 3, 2, 4, 3, 5, 3, 5, 4, 6 };