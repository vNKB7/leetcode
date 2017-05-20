package brand_new;

public class _48_Rotate_Image {

	/*
	 * A -> B: A[i][j] -> B[j][n-1-i]
	 * 
	 * B -> A: B[i][j] -> A[i][n-1-j]
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int range1 = (n + 2 - 1) / 2;
		int range2 = n / 2;

		for (int i = 0; i < range1; i++) {
			for (int j = 0; j < range2; j++) {
				int temp = matrix[i][j];
				int i_t = i, j_t = j;

				for (int k = 0; k < 3; k++) {
					matrix[i_t][j_t] = matrix[n - 1 - j_t][i_t];
					int t = i_t;
					i_t = n - 1 - j_t;
					j_t = t;
				}

				matrix[j][n - 1 - i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		new _48_Rotate_Image().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}

}
