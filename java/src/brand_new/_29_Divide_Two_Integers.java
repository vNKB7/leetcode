package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _29_Divide_Two_Integers {

	public static void main(String[] args) {
		System.out.println(new _29_Divide_Two_Integers()
				.divide(-2147483647, -2147483647));

	}
	
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		
		boolean minus_max = false;
		if (dividend == -2147483648) {
			if (divisor == 1)
				return -2147483648;
			else if (divisor == -1) {
				return 2147483647;
			}
			minus_max = true;
			dividend = -2147483647;
		}
		
		if(divisor == -2147483648){
			if(dividend == -2147483648)
				return 1;
			else
				return 0;
		}else if(divisor == 2147483647){
			if(dividend == -2147483648)
				return -1;
		}
		
		int sign = 1;
		if (dividend < 0 && divisor < 0) {
			dividend = -dividend;
			divisor = -divisor;
		} else if (dividend < 0) {
			sign = -1;
			dividend = -dividend;
		} else if (divisor < 0) {
			sign = -1;
			divisor = -divisor;
		}

		if (divisor == 1) {
			return dividend * sign;
		}

		List<Integer> stack = new ArrayList<Integer>();
		while (divisor <= dividend && divisor < 214748365) {
			stack.add(divisor);
			if(divisor >= 214748365)
				break;
			int tmp = 0;
			for (int i = 0; i < 10; i++) {
				tmp += divisor;
			}
			divisor = tmp;
		}

		int result = 0;
		while (dividend > 0) {
			if (stack.size() == 0) {
				break;
			}
			divisor = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			int count = 0;
			while (dividend - divisor >= 0) {
				count++;
				dividend -= divisor;
			}
			result = result * 10 + count;
			if(minus_max){
				dividend += 1;
				minus_max = false;
			}
		}

		return result * sign;
	}

}
