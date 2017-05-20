package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_Substring_with_Concatenation_of_All_Words {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();

		int word_len = words[0].length();
		int words_size = words.length;
		int s_length = s.length();

		HashMap<String, Integer> words_map = new HashMap<>();
		int[] counts = new int[words_size];

		for (String w : words) {
			if (!words_map.containsKey(w)) {
				words_map.put(w, words_map.size());
			}
			counts[words_map.get(w)]++;
		}

		for (int i = 0; i < word_len; i++) {
			int start = -1;
			int count = 0;
			ArrayList<int[]> range = new ArrayList<>();

			for (int j = i; j < s_length - word_len + 1; j += word_len) {
				String word = s.substring(j, j + word_len);
				if (words_map.containsKey(word)) {
					if (count == 0) {
						start = j;
					}
					count++;
				} else {
					if (count > 0) {
						if (count >= words_size) {
							range.add(new int[] { start, count });
						}
						count = 0;
					}
				}
			}

			if (count >= words_size) {
				range.add(new int[] { start, count });
			}

			for (int j = 0; j < range.size(); j++) {
				int[] r = range.get(j);
				for (int k = 0; k < r[1] - words_size + 1; k++) {
					int[] m = Arrays.copyOf(counts, counts.length);
					boolean success = true;
					for (int l = 0; l < words_size; l++) {
						String word = s.substring(r[0] + (k + l) * word_len,
								r[0] + (k + l + 1) * word_len);
						if (m[words_map.get(word)] > 0) {
							m[words_map.get(word)]--;
						} else {
							success = false;
							break;
						}
					}
					if (success) {
						res.add(r[0] + k * word_len);
					}
				}
			}
		}
		return res;
	}

	// ±ðÈËµÄsolution
	// public static List<Integer> findSubstring(String S, String[] L) {
	// List<Integer> res = new ArrayList<Integer>();
	// if (S == null || L == null || L.length == 0)
	// return res;
	// int len = L[0].length(); // length of each word
	//
	// Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
	// for (String w : L)
	// map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
	//
	// for (int i = 0; i <= S.length() - len * L.length; i++) {
	// Map<String, Integer> copy = new HashMap<String, Integer>(map);
	// for (int j = 0; j < L.length; j++) { // checkc if match
	// String str = S.substring(i + j * len, i + j * len + len); // next
	// // word
	// if (copy.containsKey(str)) { // is in remaining words
	// int count = copy.get(str);
	// if (count == 1)
	// copy.remove(str);
	// else
	// copy.put(str, count - 1);
	// if (copy.isEmpty()) { // matches
	// res.add(i);
	// break;
	// }
	// } else
	// break; // not in L
	// }
	// }
	// return res;
	// }

	public static void main(String[] args) {
		System.out.println(new _30_Substring_with_Concatenation_of_All_Words()
				.findSubstring("barfoofoobarthefoobarman", new String[] {
						"bar", "foo", "the" }));

	}
}
