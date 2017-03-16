package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		helper(result, "", n, 0);
		return result;
	}

	public List<String> helper(List<String> result, String prefix, int left,
			int right) {
		if (left == 0 && right == 0) {
			result.add(prefix);
		} else {
			if (left > 0) {
				helper(result, prefix + "(", left - 1, right + 1);
			}
			if (right > 0) {
				helper(result, prefix + ")", left, right - 1);
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
