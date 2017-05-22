package brand_new;

public class _63_Unique_Paths_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] matrix = new int[m][n];
		matrix[0][0] = 1;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(obstacleGrid[i][j] != 1){
					if(i != 0)
						matrix[i][j] += matrix[i-1][j];
					if(j != 0)
						matrix[i][j] += matrix[i][j-1];
				}
			}
		}
		return matrix[m-1][n-1];
	}

	public static void main(String[] args) {

	}

}
