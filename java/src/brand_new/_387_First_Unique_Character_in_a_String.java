package brand_new;

import java.util.Arrays;

public class _387_First_Unique_Character_in_a_String {

	public int firstUniqChar(String s) {
		int[] chs = new int[26];
		Arrays.fill(chs, -1);
		
		for(int i = 0; i < s.length(); i++){
			int j = s.charAt(i)-'a';
			if(chs[j] == -1){
				chs[j] = i;
			}else if(chs[j] >= 0){
				chs[j] = -2;
			}
		}
		
		int first = Integer.MAX_VALUE;
		for(int i = 0; i < 26; i++){
			if(chs[i] >= 0 && chs[i] < first){
				first = chs[i];
			}
		}
		
		return first == Integer.MAX_VALUE ? -1 : first;
	}

	public static void main(String[] args) {

	}

}
