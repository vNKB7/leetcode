package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _131_Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
		char[] chs = s.toCharArray();
		List<List<String>> result = new ArrayList<>();
		boolean[][] DP = new boolean[chs.length][chs.length];
		List<List<Integer>> range = new ArrayList<>();
		for (int i = 0; i < chs.length; i++)
			range.add(new ArrayList<Integer>());

		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j){
					DP[j][i] = true;
					range.get(j).add(i);
				}
				if (chs[i] == chs[j]) {
					if (i - j == 1 || i - 1 >= 0 && j + 1 < chs.length
							&& DP[j + 1][i - 1]) {
						DP[j][i] = true;
						range.get(j).add(i);
					}
				}
			}
		}
		backtrack(result, new ArrayList<String>(), 0, chs, range);
		return result;
	}

	public void backtrack(List<List<String>> result, List<String> prefix,
			int index, char[] chs, List<List<Integer>> range) {
		if (index == chs.length) {
			result.add(new ArrayList<String>(prefix));
		} else {
			List<Integer> next = range.get(index);
			for (int i : next) {
				prefix.add(new String(Arrays.copyOfRange(chs, index, i + 1)));
				backtrack(result, prefix, i + 1, chs, range);
				prefix.remove(prefix.size() - 1);
			}
		}
	} 

	public static void main(String[] args) {
		new _131_Palindrome_Partitioning().partition("aab");
		System.out.println();
	}

}
