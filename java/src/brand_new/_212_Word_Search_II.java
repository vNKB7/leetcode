package brand_new;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212_Word_Search_II {

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		if (board == null || board.length == 0 || board[0].length == 0) {
			return new ArrayList<String>();
		}

		TrieNode root = new TrieNode();
		for (String w : words) {
			insert(root, w, 0);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				backtracking(result, board, i, j, root);
			}
		}

		return new ArrayList<String>(result);
	}

	public void backtracking(Set<String> result, char[][] board, int i, int j,
			TrieNode node) {

		if (node.end) {
			result.add(node.word);
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}

		if (board[i][j] == '*') {
			return;
		}

		if (node.child[board[i][j] - 'a'] == null) {
			return;
		}

		char c = board[i][j];
		board[i][j] = '*';
		backtracking(result, board, i + 1, j, node.child[c - 'a']);
		backtracking(result, board, i - 1, j, node.child[c - 'a']);
		backtracking(result, board, i, j + 1, node.child[c - 'a']);
		backtracking(result, board, i, j - 1, node.child[c - 'a']);
		board[i][j] = c;
	}

	class TrieNode {
		boolean end;
		String word;
		char c = '.';
		TrieNode[] child = new TrieNode[26];
	}

	public void insert(TrieNode cur, String word, int index) {

		if (index != 0) {
			cur.c = word.charAt(index - 1);
		}

		if (index == word.length()) {
			cur.end = true;
			cur.word = word;
		} else {
			if (cur.child[word.charAt(index) - 'a'] == null) {
				cur.child[word.charAt(index) - 'a'] = new TrieNode();
			}
			insert(cur.child[word.charAt(index) - 'a'], word, index + 1);
		}
	}

	public static void main(String[] args) {
		String[] board_str = { "aa" };
		char[][] board = new char[board_str.length][board_str[0].length()];
		for (int i = 0; i < board_str.length; i++) {
			for (int j = 0; j < board_str[0].length(); j++) {
				board[i][j] = board_str[i].charAt(j);
			}
		}
		String[] words = { "aaa" };
		System.out.println(new _212_Word_Search_II().findWords(board, words));
	}
}
