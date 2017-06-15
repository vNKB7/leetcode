package brand_new;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _417_Pacific_Atlantic_Water_Flow {

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();

		int m = matrix.length;
		if (m == 0)
			return result;
		int n = matrix[0].length;
		if (n == 0)
			return result;

		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			pacific[i][0] = true;
			atlantic[i][n - 1] = true;
		}

		for (int i = 0; i < n; i++) {
			pacific[0][i] = true;
			atlantic[m - 1][i] = true;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				DFS(pacific, matrix, m, n, i, j, new HashSet<Integer>());
				DFS(atlantic, matrix, m, n, i, j, new HashSet<Integer>());
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j])
					result.add(new int[] { i, j });
			}
		}

		return result;
	}

	public boolean DFS(boolean[][] map, int[][] matrix, int m, int n, int i,
			int j, Set<Integer> visited) {
		int key = i * n + j;
		visited.add(key);
		map[i][j] = map[i][j]
				|| (i - 1 >= 0 && matrix[i - 1][j] <= matrix[i][j]
						&& !visited.contains((i - 1) * n + j) && DFS(map,
							matrix, m, n, i - 1, j, visited))
				|| (i + 1 < m && matrix[i + 1][j] <= matrix[i][j]
						&& !visited.contains((i + 1) * n + j) && DFS(map,
							matrix, m, n, i + 1, j, visited))
				|| (j - 1 >= 0 && matrix[i][j - 1] <= matrix[i][j]
						&& !visited.contains(i * n + j - 1) && DFS(map, matrix,
							m, n, i, j - 1, visited))
				|| (j + 1 < n && matrix[i][j + 1] <= matrix[i][j]
						&& !visited.contains(i * n + j + 1) && DFS(map, matrix,
							m, n, i, j + 1, visited));
		visited.remove(key);
		return map[i][j];

	}

	public static void main(String[] args) {
		List<int[]> result = new _417_Pacific_Atlantic_Water_Flow()
				.pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 },
						{ 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 },
						{ 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } });
		for (int[] item : result) {
			System.out.println(item[0] + " " + item[1]);
		}

	}

}
