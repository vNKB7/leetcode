package brand_new;

public class _59_Spiral_Matrix_II {
	
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int x = 0, y = 0;
		int t = 0, b = n - 1, l = 0, r = n - 1;
		char direction = 'R';
		
		for(int i = 1; i <= n * n; i++){
			matrix[x][y] = i;
			
			switch(direction){
			case 'R':
				if(y != r)
					y++;
				else{
					x++;
					t++;
					direction = 'D';
				}
				break;
				
			case 'D':
				if(x != b)
					x++;
				else{
					y--;
					r--;
					direction = 'L';
				}
				break;
				
			case 'L':
				if(y != l)
					y--;
				else{
					x--;
					b--;
					direction = 'U';
				}
				break;
				
			case 'U':
				if(x != t)
					x--;
				else{
					y++;
					l++;
					direction = 'R';
				}
				break;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		new _59_Spiral_Matrix_II().generateMatrix(5);

	}

}
