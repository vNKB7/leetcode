package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _132_Palindrome_Partitioning_II {
	public int minCut(String s) {
		char[] chs = s.toCharArray();
		boolean[][] DP = new boolean[chs.length][chs.length];

		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					DP[j][i] = true;
				}
				if (chs[i] == chs[j]) {
					if (i - j == 1 || i - 1 >= 0 && j + 1 < chs.length
							&& DP[j + 1][i - 1]) {
						DP[j][i] = true;
					}
				}
			}
		}
		
		int[] count = new int[chs.length];
		for(int i = 0; i < chs.length; i++){
			count[i] = Integer.MAX_VALUE/2;
			for(int j = 0; j <= i; j++){
				if(DP[j][i]){
					count[i] = Math.min(count[i], j > 0 ? count[j-1] + 1 : 1);
				}
			}
		}
		
		return count[count.length-1]-1;

	}

	public static void main(String[] args) {
		System.out.println(new _132_Palindrome_Partitioning_II().minCut("ababababababababcababababcbabababababababababababa"));
	}

}
