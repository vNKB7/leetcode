package brand_new;

public class _231_Power_of_Two {
	public boolean isPowerOfTwo(int n) {
		int k = 1 << 30;
		for (int i = 0; i < 30; i++) {
			System.out.println(n+" "+k);
			if (n % k == 0)
				n = n / k;
			k = k >>> 1;
		}

		return n == 1;
	}

	public static void main(String[] args) {
		System.out.println(new _231_Power_of_Two().isPowerOfTwo(1));
	}

}
