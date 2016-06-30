package leetcode;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {

		int left = 0;
		int length = 0;
		int longest = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '('){
				left++;
			}else if(c == ')'){
				if(left == 0){
					left = 0;
					length = 0;
				}else{
					left --;
					length += 2;
					
					if(longest < length)
						longest = length;
				}
			}
		}

		return longest;
	}

	public static void main(String[] args) {
		System.out.println(new LongestValidParentheses().longestValidParentheses("()(()()()("));
	}

}
