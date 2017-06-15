package brand_new;

public class _419_Battleships_in_a_Board {
	public int countBattleships(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return 0;

		int count = 0;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X')
						&& (j == 0 || board[i][j - 1] != 'X'))
					count++;

//				if (board[i][j] == 'X') {
//					if (j + 1 < n && board[i][j + 1] == 'X') {
//						if (j == 0 || board[i][j - 1] != 'X')
//							count++;
//					} else if (i + 1 < m && board[i + 1][j] == 'X') {
//						if (i == 0 || board[i - 1][j] != 'X')
//							count++;
//					} else if ((i == 0 || board[i - 1][j] == '.')
//							&& (i == m - 1 || board[i + 1][j] == '.')
//							&& (j == 0 || board[i][j - 1] == '.')
//							&& (j == n - 1 || board[i][j + 1] == '.'))
//						count++;
//				}
			}
		}

		return count;
	}

	public static void main(String[] args) {

	}

}
