package brand_new;

public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters {
	public int longestSubstring(String s, int k) {
		int max = 0;
		int[] counts = new int[26];
		boolean[] mask = new boolean[s.length()];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		
		int all = 0;
		for (int i = 0; i < s.length(); i++) {
			if (counts[s.charAt(i) - 'a'] >= k) {
				all ++;
				mask[i] = true;
			}
		}
		
		if(all == s.length())
			return s.length();

		int start = -1;
		for (int i = 0; i < mask.length; i++) {
			if (mask[i]) {
				if (start == -1)
					start = i;
			} else {
				if (start != -1) {
					if (i - start >= k) {
						max = Math.max(max,
								longestSubstring(s.substring(start, i), k));
					}
					start = -1;
				}
			}
		}

		if (start != -1) {
			if (mask.length - start >= k) {
				max = Math.max(max, longestSubstring(s.substring(start, mask.length), k));
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out
				.println(new _395_Longest_Substring_with_At_Least_K_Repeating_Characters()
						.longestSubstring("aaabb", 2));
	}
}
