package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		int[][] Iboard = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Iboard[i][j] = board[i][j] == '.' ? -1 : (board[i][j] - '0')-1;
			}
		}

		checkOneByOne(0, Iboard);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = (char) ('0'+(Iboard[i][j]+1));
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
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
		
		board[x][y] = -1;
		return false;
	}

	List<Integer> validNum(int[][] board, int x, int y) {
		int[] valid = new int[9];

		for (int i = 0; i < 9; i++) {
			if (board[x][i] != -1) {
				valid[board[x][i]] = 1;
			}

			if (board[i][y] != -1) {
				valid[board[i][y]] = 1;
			}
		}

		int x_d = x / 3;
		int y_d = y / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[x_d * 3 + i][y_d * 3 + j] != -1) {
					valid[board[x_d * 3 + i][y_d * 3 + j]] = 1;
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
		String[] str = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = str[i].charAt(j);
			}
		}
		new SudokuSolver().solveSudoku(board);
		
	}
	
}
