package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _135_Candy {

	/*复杂度高*/
	// public int candy(int[] ratings) {
	// if (ratings == null || ratings.length == 0) {
	// return 0;
	// } else if (ratings.length == 1) {
	// return 1;
	// }
	//
	// int[] candy = new int[ratings.length];
	//
	// int[] degree = new int[ratings.length];
	// List<Set<Integer>> adj = new ArrayList<>();
	// for (int i = 0; i < ratings.length; i++) {
	// adj.add(new HashSet<Integer>());
	// }
	//
	// for (int i = 1; i < ratings.length; i++) {
	// if (ratings[i] > ratings[i - 1]) {
	// adj.get(i - 1).add(i);
	// degree[i]++;
	// } else if (ratings[i] < ratings[i - 1]) {
	// adj.get(i).add(i - 1);
	// degree[i - 1]++;
	// }
	// }
	//
	// Set<Integer> s = new HashSet<>();
	// for (int i = 0; i < degree.length; i++) {
	// if (degree[i] == 0) {
	// s.add(i);
	// }
	// }
	//
	// int count = 1;
	// while (s.size() > 0) {
	// Set<Integer> newS = new HashSet<>();
	// for (int i : s) {
	// candy[i] = count;
	//
	// for (int j : adj.get(i)) {
	// degree[j]--;
	// if (degree[j] == 0) {
	// newS.add(j);
	// }
	// }
	// }
	//
	// s = newS;
	// count++;
	// }
	//
	// int sum = 0;
	// for (int c : candy) {
	// sum += c;
	// }
	// return sum;
	// }

	
	/*复杂度还是高*/
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		} else if (ratings.length == 1) {
			return 1;
		}

		int[] candy = new int[ratings.length];
		Arrays.fill(candy, Integer.MAX_VALUE / 2);

		Set<Integer> set = new HashSet<>();
		if (ratings[0] <= ratings[1]) {
			set.add(0);
		}
		if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
			set.add(ratings.length - 1);
		}

		for (int i = 1; i < ratings.length - 1; i++) {
			if (ratings[i - 1] >= ratings[i] && ratings[i] <= ratings[i + 1]) {
				set.add(i);
			}
		}

		int count = 1;
		while (set.size() > 0) {
			Set<Integer> newS = new HashSet<>();
			for (int i : set) {
				candy[i] = count;
				if (i > 0 && ratings[i] < ratings[i - 1]) {
					candy[i - 1] = Math.min(candy[i - 1], candy[i] + 1);
					newS.add(i - 1);
				}
				if (i < ratings.length - 1 && ratings[i] < ratings[i + 1]) {
					candy[i + 1] = Math.min(candy[i + 1], candy[i] + 1);
					newS.add(i + 1);
				}
			}

			set = newS;
			count++;
		}

		int sum = 0;
		for (int c : candy) {
			sum += c;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new _135_Candy().candy(new int[] { 2, 2 }));
	}

}
