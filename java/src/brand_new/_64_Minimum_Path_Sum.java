package brand_new;

public class _64_Minimum_Path_Sum {
	
	public int minPathSum(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j++){
				if(i != 0 && j != 0){
					grid[i][j] += grid[i-1][j] < grid[i][j-1] ? grid[i-1][j] : grid[i][j-1];
				}else if(i != 0){
					grid[i][j] += grid[i-1][j];
				}else if( j != 0){
					grid[i][j] += grid[i][j-1];
				}
			}
		}
		
		return grid[m-1][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
