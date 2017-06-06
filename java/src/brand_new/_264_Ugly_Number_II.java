package brand_new;


public class _264_Ugly_Number_II {

	public int nthUglyNumber(int n) {
		int[] result = new int[n];
		result[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0;
		for(int i = 1; i < n; i++){
			result[i] = Math.min(result[t2]*2, Math.min(result[t3]*3, result[t5]*5));
			if(result[i] == result[t2]*2)
				t2++;
			if(result[i] == result[t3]*3)
				t3++;
			if(result[i] == result[t5]*5)
				t5++;
		}
		return result[n-1];
	}

	public static void main(String[] args) {
		System.out.println(new _264_Ugly_Number_II().nthUglyNumber(10));
	}

}
