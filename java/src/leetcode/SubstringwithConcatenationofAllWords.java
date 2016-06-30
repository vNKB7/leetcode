package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */

/*
 * 
 ["word","good","best","good"]
 */

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
//		 new SubstringwithConcatenationofAllWords().findSubstring(
//		 "wordgoodgoodgoodbestword", new String[] { "word", "good",
//		 "best", "good" });

		new SubstringwithConcatenationofAllWords().findSubstring(
				"barfoothefoobarman", new String[] { "foo", "bar" });

	}

	HashMap<String, Integer> wordIndex = new HashMap<String, Integer>();
	int[] wordCount = null;
	int wordLength = 0;
	int[] indexMap = null;
	int totalDep = 0;

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();

		if (words == null || words.length == 0)
			return list;

		if (s == null || s.length() < words[0].length())
			return list;

		wordLength = words[0].length();
		indexMap = new int[s.length() - wordLength + 1];
		totalDep = words.length;

		int index = 0;
		for (int i = 0; i < words.length; i++) {
			if (!wordIndex.containsKey(words[i])) {
				wordIndex.put(words[i], index++);
			}
		}
		
		wordCount = new int[wordIndex.size()];
		for (int i = 0; i < words.length; i++) {
			wordCount[wordIndex.get(words[i])]++;
		}

		for (int i = 0; i < indexMap.length; i++) {
			indexMap[i] = -1;
		}

		fillIndexMap(words, s);

		for(int i = 0; i < indexMap.length; i++){
			if(indexMap[i] == -1)
				continue;
			
			int count = 0;
			int[] wordAppear = new int[wordCount.length];
			for(int start = i; start < indexMap.length; start += wordLength){
				if(indexMap[start] == -1 || wordAppear[indexMap[start]] >= wordCount[indexMap[start]]){
					break;
				}
				
				wordAppear[indexMap[start]]++;
				count++;
				
				if(count == totalDep){
					list.add(i);
//					System.out.println(i);
					break;
				}
			}
		}
		return list;
	}

	public void fillIndexMap(String[] words, String s) {
		for(int i = 0; i < indexMap.length; i++){
			String sb = s.substring(i, i + wordLength);
			Integer index = wordIndex.get(sb);
			if(index != null){
				indexMap[i] = index;
			}else{
				indexMap[i] = -1;
			}
		}
	}
}
