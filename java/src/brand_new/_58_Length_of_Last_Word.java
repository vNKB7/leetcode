package brand_new;

public class _58_Length_of_Last_Word {
	
	public int lengthOfLastWord(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		String[] piece = s.trim().split(" ");
		return piece[piece.length-1].length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
