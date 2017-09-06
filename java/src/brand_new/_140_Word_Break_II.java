package brand_new;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _140_Word_Break_II {

	public List<String> wordBreak(String s, List<String> wordDict) {
		boolean[] DP = new boolean[s.length() + 1];
		DP[0] = true;

		for (int i = 0; i < s.length(); i++) {
			for (String word : wordDict) {
				if (word.length() > i + 1) {
					continue;
				}
				if (s.substring(i - word.length() + 1, i + 1).equals(word)
						&& DP[i - word.length() + 1]) {
					DP[i + 1] = true;
					break;
				}
			}
		}

		if (!DP[DP.length - 1]) {
			return new ArrayList<String>();
		}

		List<Set<String>> result = new ArrayList<>();
		for (int i = 0; i < s.length() + 1; i++) {
			result.add(new HashSet<String>());
		}

		for (int i = 0; i < s.length(); i++) {
			for (String word : wordDict) {
				if (word.length() > i + 1) {
					continue;
				}

				if (s.substring(i - word.length() + 1, i + 1).equals(word)
						&& DP[i - word.length() + 1]) {
					if (result.get(i - word.length() + 1).size() == 0) {
						result.get(i + 1).add(word);
					} else {
						for (String word_list : result.get(i - word.length()
								+ 1)) {
							result.get(i + 1).add(word_list + " " + word);
						}
					}
				}
			}
		}

		return new ArrayList<String>(result.get(result.size() - 1));
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		for(String w : words){
			wordDict.add(w);
		}
		System.out.println(new _140_Word_Break_II().wordBreak(s, wordDict));
	}
}
