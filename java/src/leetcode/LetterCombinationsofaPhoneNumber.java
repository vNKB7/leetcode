package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LetterCombinationsofaPhoneNumber {

	String[] map = new String[] { " ", "?", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> rt = new ArrayList<String>();
		if (digits.length() == 0) {
			return rt;
		}
		parse(0, "", digits, rt);
		return rt;
	}

	void parse(int index, String str, String digits, List<String> rt) {
		if (index == digits.length()) {
			rt.add(str);
		} else {
			int n = digits.charAt(index) - '0';
			for(char c : map[n].toCharArray()){
				parse(index + 1, str + c, digits, rt);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(new LetterCombinationsofaPhoneNumber()
				.letterCombinations("2345"));
	}
	
// 用栈还没有用递归好，一定是哪里弄错了。。。
//	
//	public List<String> letterCombinations(String digits) {
//		List<String> rt = new ArrayList<String>();
//
//		if (digits.length() == 0) {
//			return rt;
//		}
//
//		Stack<Data> s = new Stack<Data>();
//
//		s.push(new Data(0, ""));
//
//		while (!s.isEmpty()) {
//
//			Data cur = s.pop();
//
//			if (cur.dep == digits.length()) {
//				rt.add(cur.str);
//			} else {
//				int curDep = cur.dep + 1;
//				for (char c : map[Integer.parseInt(digits.charAt(curDep - 1)
//						+ "")].toCharArray()) {
//					s.push(new Data(curDep, cur.str + c));
//				}
//			}
//		}
//
//		return rt;
//	}
//
//	class Data {
//		int dep;
//		String str;
//
//		public Data(int dep, String str) {
//			this.dep = dep;
//			this.str = str;
//		}
//	}
//	
}
