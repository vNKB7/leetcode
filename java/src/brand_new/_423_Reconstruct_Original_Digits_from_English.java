package brand_new;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


//e : nine one seven three five eight 
//f : four five 
//g : eight 
//h : three eight 
//i : nine six five eight 
//n : nine one seven 
//o : four one two 
//r : four three 
//s : six seven 
//t : two three eight 
//u : four 
//v : seven five 
//w : two 
//x : six 

public class _423_Reconstruct_Original_Digits_from_English {
	public String originalDigits(String s) {
		int[] x = new int[10];
		int[] alphabet = new int[26];

		for(char c : s.toCharArray())
			alphabet[c-'a']++;
		
		x[0] = alphabet['z'-'a'];
		alphabet['e'-'a'] -= x[0];
		alphabet['r'-'a'] -= x[0];
		alphabet['o'-'a'] -= x[0];
		
		x[8] = alphabet['g'-'a'];
		alphabet['e'-'a'] -= x[8];
		alphabet['h'-'a'] -= x[8];
		alphabet['i'-'a'] -= x[8];
		alphabet['t'-'a'] -= x[8];

		x[3] = alphabet['h'-'a'];
		alphabet['e'-'a'] -= 2 * x[3];
		alphabet['r'-'a'] -= x[3];
		alphabet['t'-'a'] -= x[3];
		
		x[2] = alphabet['t'-'a'];
		alphabet['o'-'a'] -= x[2];
		alphabet['t'-'a'] -= x[2];
		alphabet['w'-'a'] -= x[2];
		
		x[6] = alphabet['x'-'a'];
		alphabet['i'-'a'] -= x[6];
		alphabet['s'-'a'] -= x[6];
		
		x[4] = alphabet['u'-'a'];
		alphabet['f'-'a'] -= x[4];
		alphabet['o'-'a'] -= x[4];
		alphabet['r'-'a'] -= x[4];
		
		x[5] = alphabet['f'-'a'];
		alphabet['e'-'a'] -= x[5];
		alphabet['i'-'a'] -= x[5];
		alphabet['v'-'a'] -= x[5];
		
		x[9] = alphabet['i'-'a'];
		alphabet['e'-'a'] -= x[9];
		alphabet['n'-'a'] -= 2 * x[9];
		
		x[1] = alphabet['o'-'a'];
		x[7] = alphabet['v'-'a'];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++){
			if(x[i] != 0){
				for(int j = 0; j < x[i]; j++)
					sb.append(i);
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new _423_Reconstruct_Original_Digits_from_English().originalDigits("owoztneoer"));
	}

}
