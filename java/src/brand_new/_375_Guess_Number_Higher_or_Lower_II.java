package brand_new;

public class _375_Guess_Number_Higher_or_Lower_II {
	public int getMoneyAmount(int n) {
		int[][] DP = new int[n + 1][n + 1];
		for (int j = 1; j < n + 1; j++) {
			for (int i = j - 1; i >= 1; i--) { // 这里是逆序。要从小事件开始遍历。这种地方一定要检查好！！
				int min = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++)
					min = Math.min(min,
							k + Math.max(DP[i][k - 1], DP[k + 1][j]));
				DP[i][j] = min;
			}
		}
		return DP[1][n];
	}

	public static void main(String[] args) {
		System.out.println(new _375_Guess_Number_Higher_or_Lower_II()
				.getMoneyAmount(10));
	}

}
