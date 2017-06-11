package brand_new;

public class _389_Find_the_Difference {
	
	public char findTheDifference(String s, String t) {
		int[] chs = new int[26];
		for(int i = 0; i < s.length(); i++)
			chs[s.charAt(i)-'a']++;
		
		for(int i = 0; i < t.length(); i++)
			if(--chs[t.charAt(i)-'a'] < 0)
				return t.charAt(i);
		
		return 'a';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
