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

//I misunderstood the problem and ignore the "without any intervening characters"
public class SubstringwithConcatenationofAllWords_fake {

	public static void main(String[] args) {
		 new SubstringwithConcatenationofAllWords_fake().findSubstring(
		 "wordgoodgoodgoodbestword", new String[] { "word", "good",
		 "best", "good" });

//		new SubstringwithConcatenationofAllWords_fake().findSubstring(
//				"barfoothefoobarman", new String[] { "foo", "bar" });

	}

	HashMap<String, Integer> wordIndex = new HashMap<String, Integer>();
	int[] wordCount = null;
	int wordLength = 0;
	int[] indexMap = null;
	int totalDep = 0;

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();

		if (words == null || words.length == 0)
			return null;

		if (s == null || s.length() < words[0].length())
			return null;

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

//		for(int i = 0; i < indexMap.length; i++){
//			System.out.println(indexMap[i]);
//		}
		
		for (int i = 0; i < indexMap.length; i++) {
			if (indexMap[i] != -1) {
				int[] wordAppear = new int[wordCount.length];
				wordAppear[indexMap[i]] = 1;
				if (handle(i, wordAppear, 1)) {
//					System.out.println(i);
					list.add(i);
				}
			}
		}

		return list;
	}

	public void fillIndexMap(String[] words, String s) {

		Iterator iter = wordIndex.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String findWord = (String) entry.getKey();
			int i = (int) entry.getValue();
			
			int startIndex = 0;
			while (startIndex <= indexMap.length) {
				int findIndex = s.indexOf(findWord, startIndex);

				if (findIndex != -1) {
					indexMap[findIndex] = i;
					startIndex = findIndex + 1;
				} else {
					break;
				}
			}
		}
	}

	public boolean handle(int start, int[] wordAppear, int dep) {
		if (dep == totalDep)
			return true;

		start += wordLength;
		if (start >= indexMap.length)
			return false;

		int next = -1;
		for (int i = start; i < indexMap.length; i++) {
			if (indexMap[i] != -1) {
				next = i;
				break;
			}
		}

		if (next == -1)
			return false;

		start = next;

		if (wordAppear[indexMap[start]] >= wordCount[indexMap[start]]) {
			int count = 0;
			for (int i = start + 1; i < Math.min(start + wordLength,
					indexMap.length); i++) {
				if (indexMap[i] != -1
						&& wordAppear[indexMap[i]] < wordCount[indexMap[start]]) {
					count++;
				}
			}
			if (count == 0)
				return false;
		} else {
			int[] newWordAppear = wordAppear.clone();
			newWordAppear[indexMap[start]]++;
			if (handle(start, newWordAppear, dep + 1))
				return true;
		}

		for (int i = start + 1; i < Math.min(start + wordLength,
				indexMap.length); i++) {
			if (indexMap[i] != -1
					&& wordAppear[indexMap[i]] < wordCount[indexMap[start]]) {
				int[] newWordAppear = wordAppear.clone();
				newWordAppear[indexMap[i]]++;
				if (handle(i, newWordAppear, dep + 1))
					return true;
			}
		}

		return false;
	}

}
