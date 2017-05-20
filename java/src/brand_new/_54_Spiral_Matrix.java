package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();

		int m = matrix.length;
		if (m == 0)
			return result;
		int n = matrix[0].length;
		if (n == 0)
			return result;

		int x = 0, y = 0;
		char c = 'R';
		int r_s = 0, r_e = m - 1, c_s = 0, c_e = n - 1;

		for (int i = 0; i < m * n; i++) {
			result.add(matrix[x][y]);
			switch (c) {
			case 'R':
				if (y == c_e) {
					r_s++;
					c = 'D';
					x++;
				} else
					y++;
				break;
			case 'D':
				if (x == r_e) {
					c_e--;
					c = 'L';
					y--;
				} else
					x++;
				break;
			case 'L':
				if (y == c_s) {
					r_e--;
					c = 'U';
					x--;
				} else
					y--;
				break;
			case 'U':
				if (x == r_s) {
					c_s++;
					c = 'R';
					y++;
				} else
					x--;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _54_Spiral_Matrix().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
	}

}
