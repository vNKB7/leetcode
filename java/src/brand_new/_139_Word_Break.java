package brand_new;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _139_Word_Break {

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] DP = new boolean[s.length()+1];
		DP[0] = true;

		Collections.sort(wordDict, (o1, o2)->{
			return o1.length() - o2.length();
		});
		
		for(int i = 0; i < s.length(); i++){
			for(String word : wordDict){
				if(word.length() > i + 1){
					break;
				}
				if(s.substring(i-word.length()+1 ,i+1).equals(word) && DP[i-word.length()+1]){
					DP[i+1] = true;
					break;
				}
			}
		}
		
		return DP[DP.length-1];
	}

	//这是没优化的版本（没有排序），竟然比优化过的快。。。这个排序的代价这么高么。。
//	public boolean wordBreak(String s, List<String> wordDict) {
//		boolean[] DP = new boolean[s.length()+1];
//		DP[0] = true;
//
//		for(int i = 0; i < s.length(); i++){
//			for(String word : wordDict){
//				if(word.length() > i + 1){
//					continue;
//				}
//				if(s.substring(i-word.length()+1 ,i+1).equals(word) && DP[i-word.length()+1]){
//					DP[i+1] = true;
//					break;
//				}
//			}
//		}
//		
//		return DP[DP.length-1];
//	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("cod");
		System.out.println(new _139_Word_Break().wordBreak(s, wordDict));
	}

}
