package brand_new;

public class Longest_Palindromic_Substring_5 {
	int lo = 0, length = 0;
	public String longestPalindrome(String s) {
		if(s.length() < 2){
			return s;
		}
		
		int longest = 0;
		String longest_str = s.charAt(0)+"";
		
		for(int i = 0; i < s.length()-1; i++){
			sub_L_P(s, i, i);
			sub_L_P(s, i, i+1);
		}
		
		return s.substring(lo, lo+length);
	}
	
	public void sub_L_P(String s, int i, int j){
		while(i >= 0 && j < s.length() && s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
		if(j-i-1 > length){
			lo = i+1;
			length = j-i-1;
		}
	}
	

	public static void main(String[] args) {
		System.out.println(new Longest_Palindromic_Substring_5().longestPalindrome("cbbd"));
	}

}
