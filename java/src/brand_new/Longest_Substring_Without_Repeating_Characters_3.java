package brand_new;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 {
	public int lengthOfLongestSubstring1(String s) {
		if(s.length() <= 1){
			return s.length();
		}
		
		int max_lenth = 1;
		int start = 0;
		for(int i = 1; i < s.length(); i++){
			boolean f = true;
			for(int j = start; j < i; j++){
				if(s.charAt(i) == s.charAt(j)){
					start = j+1;
					f = false;
					break;
				}
			}
			if(f && i-start+1 > max_lenth){
				max_lenth = i-start+1;
			}
		}
		return max_lenth;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		if(s.length() <= 1){
			return s.length();
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int longest = 1;
		int start = 0;
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i)))
				start = start > map.get(s.charAt(i)) + 1 ? start : map.get(s.charAt(i)) + 1;
			longest = i-start+1 > longest ? i-start+1 : longest;
			map.put(s.charAt(i), i);
		}
		
		return longest;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Longest_Substring_Without_Repeating_Characters_3().lengthOfLongestSubstring2("abcabcbb"));
	}
}
