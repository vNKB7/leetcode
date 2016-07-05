package leetcode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0 || dividend == 0)
			return 0;
		if(divisor < -2147483648 || divisor >2147483647 || dividend < -2147483648 || dividend >2147483647)
			return 0;
		
		int sign = (dividend > 0)&&(divisor > 0)||(dividend < 0)&&(divisor < 0)?1:-1;
		
		long dividendL = dividend;
		long divisorL = divisor;

		dividendL = dividendL >= 0 ? dividendL:-dividendL;
		divisorL = divisorL >= 0?divisorL:-divisorL;
		
		long result = 0;
		
		if (divisorL == 1) {
			result = dividendL;
		}else{
			result = recursion(dividendL, divisorL).quotient;
		}

		if(sign > 0){
			if(result > 2147483647)
				return Integer.MAX_VALUE;
			else
				return (int)result;
		}else{
			if(result > 2147483648L)
				return Integer.MAX_VALUE;
			else
				return -(int)result;
		}
	}

	public Quotient recursion(long dividend, long divisor) {
		if (dividend < divisor) {
			return new Quotient(dividend, 0L);
		} else {
			long nextDivisor = 0;
			long count = 0;

			for (int i = 0; i < 10; i++) {
				nextDivisor += divisor;
			}

			if (nextDivisor > 0) {
				Quotient q = recursion(dividend, nextDivisor);
				
					for (int i = 0; i < 10; i++) {
						count += q.quotient;
					}
					dividend = q.remainder;
				if(q.remainder < divisor){
					return new Quotient(dividend, count);
				}

				
			} else {
				count = 0;
			}

			while (dividend >= divisor) {
				dividend -= divisor;
				count++;
			}

			return new Quotient(dividend, count);
		}
	}

	class Quotient {
		long remainder;
		long quotient;

		public Quotient(long remainder, long quotient) {
			this.remainder = remainder;
			this.quotient = quotient;
		}
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-2147483648,-3));

	}

}
