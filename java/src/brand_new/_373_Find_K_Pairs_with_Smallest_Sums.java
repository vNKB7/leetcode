package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _373_Find_K_Pairs_with_Smallest_Sums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<int[]>();
		Set<Integer> added = new HashSet<>();
		if(nums1.length == 0 || nums2.length == 0)
			return result;
		
		Queue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.sum - o2.sum;
			}
		});
		
		heap.add(new Pair(0, 0, nums1[0]+nums2[0]));
		added.add(0);
		for(int i = 0; i < k && heap.size() > 0; i++){
			Pair min = heap.poll();
			if(min.i < nums1.length-1 && !added.contains((min.i+1)*nums2.length+min.j)){
				heap.add(new Pair(min.i+1, min.j, nums1[min.i+1]+nums2[min.j]));
				added.add((min.i+1)*nums2.length+min.j);
			}
			if(min.j < nums2.length-1 && !added.contains(min.i*nums2.length+min.j+1)){
				heap.add(new Pair(min.i, min.j+1, nums1[min.i]+nums2[min.j+1]));
				added.add(min.i*nums2.length+min.j+1);
			}
			result.add(new int[]{nums1[min.i], nums2[min.j]});
		}
		
		return result;
	}

	class Pair {
		int i;
		int j;
		int sum;

		public Pair(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
	}

	public static void main(String[] args) {
		List<int[]> result = new _373_Find_K_Pairs_with_Smallest_Sums().kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 3);
		for(int[] i : result){
			System.out.println(Arrays.toString(i));
		}
	}

}
