package brand_new;

public class _409_Longest_Palindrome {
	public int longestPalindrome(String s) {
		int[] counts = new int[52];
		for(char c : s.toCharArray()){
			if(c>='a' && c <= 'z'){
				counts[c-'a']++;
			}else{
				counts[26+c-'A']++;
			}
		}
		
		int length = 0;
		int odd = 0;
		for(int i : counts){
			if(i % 2 == 1)
				odd = 1;
			length += i / 2;
		}
		
		return length * 2 + odd;
	}

	public static void main(String[] args) {

	}

}
