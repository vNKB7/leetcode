package brand_new;

import java.util.Arrays;
import java.util.TreeSet;

public class _435_Non_overlapping_Intervals {
	class Item {
		int end;
		int count;

		public Item(int end, int count) {
			this.end = end;
			this.count = count;
		}
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, (o1, o2) -> {
			return o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end;
		});

		TreeSet<Item> set = new TreeSet<Item>((o1, o2) -> {
			return o1.end - o2.end;
		});

		int[] count = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++){
			count[i] = Math.max(1, Math.max(i == 0 ? 0 : count[i-1], set.lower(new Item(intervals[i].start, 0)) != null ? count[set.lower(new Item(intervals[i].start, 0)).count]+1 : 0));
			set.add(new Item(i, count[i]));
		}
		
		return intervals.length - count[count.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
