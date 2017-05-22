package brand_new;

public class _74_Search_a_2D_Matrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0, end = m * n;

		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[mid / n][mid % n] == target) {
				return true;
			} else if (matrix[mid / n][mid % n] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
