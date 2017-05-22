package brand_new;

public class _73_Set_Matrix_Zeroes {

	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;

		int row0 = 1, col0 = 1;
		for (int i = 0; i < n; i++)
			if (matrix[0][i] == 0) {
				row0 = 0;
				break;
			}

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				col0 = 0;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (row0 == 0)
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;

		if (col0 == 0)
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
