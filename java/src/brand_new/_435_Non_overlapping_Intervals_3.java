package brand_new;

import java.util.Arrays;
import java.util.Comparator;

// interval scheduling maximization problem (ISMP)   https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
// upgrated : group interval scheduling decision problem (GISDP)

// 通过end对Interval排序。每次取最小的end，并将其及与其重叠的interval删除。
// 因为对于一组相交的interval来说，最多只能留一个interval，同时要保证留下的interval最多，那么要留肯定是end最小的。

public class _435_Non_overlapping_Intervals_3 {

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new myComparator());
		int end = intervals[0].end;
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= end) {
				end = intervals[i].end;
				count++;
			}
		}
		return intervals.length - count;
	}

	class myComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.end - b.end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
