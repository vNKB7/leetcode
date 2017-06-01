package brand_new;

import java.util.Stack;

public class _150_Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+") || s.equals("-") || s.equals("*")
					|| s.equals("/")) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				if (s.equals("+")) {
					stack.push(num1 + num2);
				} else if (s.equals("-")) {
					stack.push(num1 - num2);
				} else if (s.equals("*")) {
					stack.push(num1 * num2);
				} else if (s.equals("/")) {
					stack.push(num1 / num2);
				}
			} else {
				stack.push(Integer.parseInt(s));
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(new _150_Evaluate_Reverse_Polish_Notation()
				.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
	}

}
