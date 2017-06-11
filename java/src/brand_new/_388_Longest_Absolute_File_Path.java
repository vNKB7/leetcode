package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _388_Longest_Absolute_File_Path {

	public int lengthLongestPath(String input) {
		if (input == null)
			return 0;

		String[] lines = input.split("\n");

		if (lines.length == 0)
			return 0;

		List<Integer> list = new ArrayList<Integer>();
		int length = 0;
		int max = 0;
		for (int i = 0; i < lines.length; i++) {
			String[] piece = lines[i].split("\t");
			int depth = piece.length - 1;
			if (depth == 0) {
				list = new ArrayList<Integer>();
				length = piece[0].length();
				list.add(length);
				if (piece[piece.length - 1].contains(".") && length > max)
					max = length;
				continue;
			}
			while (list.size() > depth) {
				length -= list.remove(list.size() - 1);
			}
			list.add(piece[piece.length - 1].length() + 1);
			length += piece[piece.length - 1].length() + 1;
			if (piece[piece.length - 1].contains(".") && length > max)
				max = length;
		}

		return max;
	}

	public static void main(String[] args) {
		String str = "a.txt";
		System.out.println(str);
		System.out.println(new _388_Longest_Absolute_File_Path()
				.lengthLongestPath(str));
	}

}
