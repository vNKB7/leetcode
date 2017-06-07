package brand_new;

public class _371_Sum_of_Two_Integers {
	public int getSum(int a, int b) {
		int result = 0;
		int c = 0;
		for (int i = 0; i < 32; i++) {
			int x = a & 1;
			int y = b & 1;
			int z = (x | y | c) & (x ^ y ^ c);
			c = (x | y | c) & (z ^ (1 ^ (x & y & c)));
			result |= z << i;
			a >>>= 1;
			b >>>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _371_Sum_of_Two_Integers().getSum(-5, -3));
	}

}
