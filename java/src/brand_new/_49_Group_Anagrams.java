package brand_new;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _49_Group_Anagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> result = new HashMap<>();
		
		for(String s : strs){
			String key = getKey(s);
			
			if(!result.containsKey(key)){
				result.put(key, new ArrayList<String>());
			}
			
			result.get(key).add(s);
		}
		
		return new ArrayList<List<String>>(result.values());
	}

	public String getKey(String s) {
		int[] counts = new int[26];
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < 26; i++){
			if(counts[i] != 0){
				result.append((char)('a'+i));
				result.append(counts[i]);
			}
		}
		
		return result.toString();
	}

	public static void main(String[] args) {

	}
}
