package brand_new;

import java.util.HashSet;
import java.util.Set;

public class _79_Word_Search {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (search(board, m, n, word, 0, i, j))
					return true;
			}
		}
		return false;
	}

	public boolean search(char[][] board, int m, int n, String word, int index,
			int x, int y) {
		if (board[x][y] != word.charAt(index))
			return false;

		if (index == word.length() - 1)
			return true;

		char c = board[x][y];
		board[x][y] = '#';

		boolean exist = (x > 0 && search(board, m, n, word, index + 1, x - 1, y))
				|| (y > 0 && search(board, m, n, word, index + 1, x, y - 1))
				|| (x < m - 1 && search(board, m, n, word, index + 1, x + 1, y))
				|| (y < n - 1 && search(board, m, n, word, index + 1, x, y + 1));

		board[x][y] = c;
		return exist;
	}
}
