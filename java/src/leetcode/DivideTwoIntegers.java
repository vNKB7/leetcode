package leetcode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if(divisor == 0)
			return Integer.MAX_VALUE;
		
		int sign = dividend * divisor > 0 ? 1 : -1;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if(divisor == 1){
			return sign > 0?dividend:-dividend;
		}
		
		int count = 0;
		
		while(dividend >= divisor){
			dividend -= divisor;
			count++;
		}
		
		return sign > 0?count:-count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
