package brand_new;

public class _392_Is_Subsequence {
	public boolean isSubsequence(String s, String t) {
		char[] S = s.toCharArray();
		char[] T = t.toCharArray();
		
		int i = 0, j = 0;
		for(; j < T.length && i < S.length; j++){
			if(S[i] == T[j])
				i++;
		}
		
		return i == S.length;
	}

	public static void main(String[] args) {
		System.out.println(new _392_Is_Subsequence().isSubsequence("abc", "ahbgdc"));
	}

}
