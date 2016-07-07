package leetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][][] box = new boolean[3][3][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				char c = board[i][j];
				if(c == '.')
					continue;
				int num = (c - '0') - 1;
				
				if(row[i][num] == true)
					return false;
				else
					row[i][num] = true;
				
				if(col[j][num] == true)
					return false;
				else 
					col[j][num] = true;
				
				if(box[i/3][j/3][num] == true)
					return false;
				else
					box[i/3][j/3][num] = true;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
	}

}
