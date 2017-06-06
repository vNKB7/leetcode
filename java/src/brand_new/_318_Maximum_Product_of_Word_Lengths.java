package brand_new;

import java.util.Arrays;
import java.util.Comparator;

public class _318_Maximum_Product_of_Word_Lengths {
	static int[] codeList = new int[26];
	static {
		int code = 1;
		for (int i = 0; i < 26; i++) {
			codeList[i] = code;
			code <<= 1;
		}
	}

	class Word {
		int length = 0;
		int id = 0;

		public Word(String word) {
			this.length = word.length();
			this.id = getId(word);
		}

		int getId(String word) {
			int i = 0;
			for(char c : word.toCharArray()){
				i |= codeList[c-'a'];
			}
			return i;
		}
	}

	public int maxProduct(String[] words) {
		Word[] wordList = new Word[words.length];
		for(int i = 0; i < words.length; i++){
			wordList[i] = new Word(words[i]);
		}
		
		Arrays.sort(wordList, new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				return o2.length - o1.length;
			}
		});
		
		int max = 0;
		for(int i = 0; i < wordList.length-1; i++){
			for(int j = i + 1; j < wordList.length; j++){
				int curLen = wordList[i].length * wordList[j].length;
				if(curLen < max)
					break;
				if((wordList[i].id & wordList[j].id) == 0){
					max = curLen;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new _318_Maximum_Product_of_Word_Lengths().maxProduct(new String[]{"ccd","accaceddeeeaefc","bcaffa","bbcfafbb","accacfebbabbeedfbfdb","beddecbffcdaededdaefdedfdea","cf","ddafdcbd","bbafacebacaefdaffccebddff","ebccffcddbeddccacceccaec","becfbfdccdfdeadfbfaddbcded","cbabeaaeabefedbaeaedc","dfadbbdbead","cafaefdcd","eccdbfceafeeeacfcddc","dbabbcdbb","abfbfbffcbebde","cfaadaa","fc","faebcabb","adbacebabcaaccbdeaffff","aeaefccf","dbacbeeabdbcdfccabebaecfef","ecdadeefcaddffaececffa","defcabf","abbcecbccbdaebaecaefabed","dfeeebcbaaefc","aecccbcbbdddb","dcfabacec","fccfbacbacddeaaea","dfdbfacbacbecb","cbfeebdbfecb","cffaacacbde","aafd","bdcebbbebd","afeffadcfcdacfba","dafeefbcdfaffcfacee","dcbbebfbedafedcdbab","cafaf","bcbcccfdebdd","efaaaacccff","cffbead","ebcfccfcddffdec","fffdfdcec","beeafefbdfa","cdfdbccfbaaeffcabab","ddadcbabbcb","decfaeabbecebaebeaddedae","cdcbfffbebae","aeccefcbcbbddfdc","ffefedaf","cddbabccafaffeafeedcbedbdad","eddeeccfedcefadfdfebfacb","aca","ffdcafaddcddf","ef","bbbbffe","ffccfebabaadcffacbbb","cbdeddfddffacbeeeebafebabda","ddeecb","cffdc","edcffcebadf","becbcadcafddcfbbeeddbfffcab","abcbaceeaeaddd","cfeffceebfaeefadaaccfa","eaccddb","caeafbfafecd","becaafdbaadbfecfdfde","ecabaaeafbfbcbadaac","bdcdffcfaeebeedfdfddfaf","dbbfbaeecbfcdebad","cceecddeeecdbde","beec","adbcfdbfdbccdcffffbcffbec","bbbbfe","cdaedaeaad","dadbfeafadd","fcacaaebcedfbfbcddfc","ceecfedceac","dada","ccfdaeffbcfcc","eadddbbbdfa","beb","fcaaedadabbbeacabefdabe","dfcddeeffbeec","defbdbeffebfceaedffbfee","cffadadfbaebfdbadebc","fbbadfccbeffbdeabecc","bdabbffeefeccb","bdeeddc","afcbacdeefbcecff","cfeaebbbadacbced","edfddfedbcfecfedb","faed","cbcdccfcbdebabc","efb","dbddadfcddbd","fbaefdfebeeacbdfbdcdddcbefc","cbbfaccdbffde","adbcabaffebdffad"}));
	}

}
