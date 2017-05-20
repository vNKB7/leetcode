package brand_new;

public class _32_Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
		int global = 0;
		int cur = 0;
		int left = 0;
		int c = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
				c = 0;
			} else {
				left--;
				cur++;
				if (left == 0) {
					global = global > cur ? global : cur;
				} else if (left < 0) {
					cur = 0;
					left = 0;
				} else {
					c++;
					global = global > c ? global : c;
				}
			}
		}

		return global * 2;
	}

	public static void main(String[] args) {
		System.out.println(new _32_Longest_Valid_Parentheses()
				.longestValidParentheses("()(()"));

	}

}
