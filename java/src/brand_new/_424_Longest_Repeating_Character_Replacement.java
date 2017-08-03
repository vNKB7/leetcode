package brand_new;

import java.util.LinkedList;

public class _424_Longest_Repeating_Character_Replacement {

	public int characterReplacement(String s, int k) {
		int global = 0;
		s = s + "$";
		char[] chs = s.toCharArray();

		for (int i = 0; i < 26; i++) {
			int max = 0;
			int remain = k;
			int max_remain = k;
			int c = (char) ('A' + i);
			LinkedList<Integer> queue = new LinkedList<>();
			int local = 0;
			int len = 0;
			boolean last = false;
			for (int j = 0; j < chs.length; j++) {
				if (chs[j] == c) {
					if (last)
						len++;
					else {
						last = true;
						if (len > k) {
							queue = new LinkedList<>();
							len = 1;
							remain = k;
							local = 0;
							last = true;
						} else {
							while (len > remain) {
								local -= queue.poll();
								local -= queue.peek();
								remain += queue.poll();
							}
							if (queue.size() > 0) {
								remain -= len;
								queue.add(len);
								local += len;
							}
							len = 1;
						}
					}
				} else {
					if (!last) {
						len++;
					} else {
						queue.add(len);
						local += len;
						len = 1;
						last = false;
					}
				}

				if (max < local){
					max = local;
					max_remain = remain;
				}
			}

			if (max_remain > 0) {
				if (chs.length - 1 > max_remain + max)
					max = max_remain + max;
				else
					max = chs.length - 1;
			}

			if (global < max)
				global = max;
		}

		return global;
	}

	public static void main(String[] args) {
		System.out.println(new _424_Longest_Repeating_Character_Replacement()
				.characterReplacement("ABAA", 0));
	}

}
