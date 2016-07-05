package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();

		int[] index = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				st.push(i);
			} else if (c == ')') {
				if (!st.isEmpty()) {
					int left = st.pop();
					index[left] = i - left + 1;
				}
			}
		}

		int longest = 0;
		int curLength = 0;

		int i = 0;
		while(i < index.length){
			if(index[i] == 0){
				if(curLength > longest)
					longest = curLength;
				curLength = 0;
				i++;
			}else{
				curLength += index[i];
				i += index[i];
			}
		}
		

		if (curLength > longest) {
			longest = curLength;
		}

		return longest;
	}

	public static void main(String[] args) {
		System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
	}

}



