package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		int[][] Iboard = new int[9][9];
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				Iboard[i][j] = board[i][j] == '.' ? -1 : Integer
//						.parseInt(board[i][j] + "")-1;
//			}
//		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for(int k = 0; k < 9; k++){
					Iboard[i*3+k/3][j*3+k%3] = board[i*3 + j][k] == '.' ? -1 : Integer.parseInt(board[i*3 + j][k] + "")-1;
				}
			}
		}

		return checkOneByOne(0, Iboard);
	}

	boolean checkOneByOne(int index, int[][] board) {
		int x = 0, y = 0;
		for (; index < 81; index++) {
			if (board[index / 9][index % 9] == -1) {
				x = index / 9;
				y = index % 9;
				break;
			}
		}
		
		if (index == 81)
			return true;

		List<Integer> candidates = validNum(board, x, y);

		if (candidates == null || candidates.size() == 0) {
			return false;
		}

		for (int candidate : candidates) {
			board[x][y] = candidate;
			if (checkOneByOne(index, board)) {
				return true;
			}
		}
		return false;
	}

	List<Integer> validNum(int[][] board, int x, int y) {
		int[] valid = new int[9];

		for (int i = 0; i < 9; i++) {
			if (board[x][i] != -1) {
				valid[i] = 1;
			}

			if (board[i][y] != -1) {
				valid[i] = 1;
			}
		}

		int x_d = x / 3;
		int y_d = y / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[x_d * 3 + i][y_d * 3 + j] != -1) {
					valid[i] = 1;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < valid.length; i++){
			if(valid[i] == 0){
				list.add(i);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		String[] str = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = str[i].charAt(j);
			}
		}
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}

}
