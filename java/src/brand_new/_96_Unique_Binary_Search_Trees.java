package brand_new;

public class _96_Unique_Binary_Search_Trees {
	public int numTrees(int n) {
		int[][] DP = new int[n + 1][n + 1];

		return getNums(1, n, DP);
	}

	public int getNums(int min, int max, int[][] DP) {
		int count = 0;
		if (min >= max) {
			return 1;
		}

		if (DP[min][max] == 0) {
			for (int i = min; i <= max; i++) {
				int left = getNums(min, i - 1, DP);
				int right = getNums(i + 1, max, DP);
				count += left * right;
			}
			DP[min][max] = count;
		}
		return DP[min][max];
	}

	// 别人的
	// public int numTrees(int n) {
	// int [] G = new int[n+1];
	// G[0] = G[1] = 1;
	//
	// for(int i=2; i<=n; ++i) {
	// for(int j=1; j<=i; ++j) {
	// G[i] += G[j-1] * G[i-j];
	// }
	// }
	//
	// return G[n];
	// }
	public static void main(String[] args) {
		System.out.println(new _96_Unique_Binary_Search_Trees().numTrees(10));
	}

}
