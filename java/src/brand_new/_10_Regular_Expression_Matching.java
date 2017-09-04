package brand_new;

public class _10_Regular_Expression_Matching {

	public static void main(String[] args) {
		System.out.println(new _10_Regular_Expression_Matching().isMatch("aaa", "ab*a"));
	}
	
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		if (p.length() == 0) {
			return false;
		}

		boolean[][] DP = new boolean[s.length() + 1][p.length() + 1];
		DP[0][0] = true;

		for (int i = 1; i < p.length(); i += 2) {
			if (p.charAt(i) == '*') {
				DP[0][i + 1] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if(s.charAt(i-1) == p.charAt(j-1)){
					DP[i][j] = DP[i-1][j-1];
				}else if(p.charAt(j-1) == '.'){
					DP[i][j] = DP[i-1][j-1];
				}else if(p.charAt(j-1) == '*'){
					if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
						DP[i][j] = DP[i-1][j] || DP[i][j-1] || DP[i][j-2];
					}else{
						DP[i][j] = DP[i][j-2];
					}
				}
			}
		}

		return DP[s.length()][p.length()];
	}
}
