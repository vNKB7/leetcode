package brand_new;

public class _172_Factorial_Trailing_Zeroes {
	
	public int trailingZeroes(int n) {
		int count = 0;
		while(n > 0){
			n = n / 5;
			count += n;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
