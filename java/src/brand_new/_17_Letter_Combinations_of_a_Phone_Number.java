package brand_new;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return result;
		}
		result.add("");
		String[] map = new String[] { " ", "", "abc", "def", "ghi", "jkl",
				"mno", "pqrs", "tuv", "wxyz" };
		for (int i = 0; i < digits.length(); i++) {
			String next = map[digits.charAt(i) - '0'];
			List<String> new_result = new ArrayList<String>();
			for (int j = 0; j < next.length(); j++) {
				for(String s : result){
					new_result.add(s+next.charAt(j));
				}
			}
			result = new_result;
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> result = new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("234");
		for(String s : result){
			System.out.println(s);
		}
	}

}
