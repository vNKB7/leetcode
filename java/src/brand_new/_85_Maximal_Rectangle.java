package brand_new;

public class _85_Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
		// Write your code here
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int maxArea = 0;
		int[][][] DP = new int[m][n][2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0) {
						DP[i][j][1] = 1;
					} else {
						DP[i][j][1] = DP[i - 1][j][1] + 1;
					}

					if (j == 0) {
						DP[i][j][0] = 1;
					} else {
						DP[i][j][0] = DP[i][j - 1][0] + 1;
					}

					int maxH = DP[i][j][1];
					for (int k = 0; k < DP[i][j][0]; k++) {
						int x = j - k;
						maxH = Math.min(DP[i][x][1], maxH);
						maxArea = Math.max(maxArea, maxH * (k + 1));
					}
				}
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
