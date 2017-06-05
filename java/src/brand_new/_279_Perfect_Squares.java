package brand_new;

public class _279_Perfect_Squares {
	public int numSquares(int n) {
		int k = (int) Math.sqrt((double) n);
		int[] C = new int[k];
		for (int i = 1; i <= k; i++) {
			C[i - 1] = i * i;
		}

		int[] DP = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			DP[i] = -1;

		for (int i = 0; i < k; i++) {
			for (int j = C[i]; j <= n; j++) {
				if(DP[j - C[i]] >= 0 && DP[j] >= 0)
					DP[j] = Math.min(DP[j - C[i]] + 1, DP[j]);
				else if(DP[j - C[i]] >= 0)
					DP[j] = DP[j - C[i]]+1;
			}
		}
		return DP[n];
	}

	public static void main(String[] args) {
		System.out.println(new _279_Perfect_Squares().numSquares(12));
	}

}
