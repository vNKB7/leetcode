package brand_new;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _56_Merge_Intervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		
		if(intervals == null || intervals.size() == 0)
			return result;
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1 != o2){
					return o1.start - o2.start;
				}else{
					return o1.end - o2.end;
				}
			}
		});
		
		Interval cur = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++){
			Interval tmp = intervals.get(i);
			if(tmp.start <= cur.end){
				cur.end = cur.end > tmp.end ? cur.end : tmp.end;
			}else{
				result.add(cur);
				cur = tmp;
			}
		}
		
		result.add(cur);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
