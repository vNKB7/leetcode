package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		return helper("", n, 0);
	}

	public List<String> helper(String prefix, int left, int right) {
		List<String> result = new ArrayList<String>();
		if (left == 0 && right == 0) {
			result.add(prefix);
		} else {
			if (left > 0) {
				result.addAll(helper(prefix + "(", left - 1, right + 1));
			}
			if (right > 0) {
				result.addAll(helper(prefix + ")", left, right - 1));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = new _22_Generate_Parentheses()
				.generateParenthesis(3);
		for (String str : result) {
			System.out.println(str);
		}

	}

}
