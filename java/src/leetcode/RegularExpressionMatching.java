package leetcode;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		p = p+'$';
		s = s+'$';
		int s_i =  0, p_i = 0;
		int slen = s.length(), plen = p.length();
		
		if(slen == 0 || plen == 0){
			if(slen == plen)
				return true;
			else
				return false;
		}
		
		while(true){
			if(p_i == plen && s_i == slen)
				return true;
			if(p_i == plen && s_i != slen || p_i != plen && s_i == slen)
				return false;
			char p_cur = p.charAt(p_i);
			if(p_cur == '.'){
				if(p_i + 1 < plen){
					if(p.charAt(p_i+1)=='*'){
						for(; s_i < slen; s_i++){
							if(isMatch(s.substring(s_i),p.substring(p_i+2))){
//								s_i += 1;
								break;
							}
						}
						p_i += 2;
					}else{
						p_i++;
						s_i++;
					}
				}else{
					if(s_i + 1 != slen)
						return false;
					else
						return true;
				}
			}else if(p_cur != '*'){
				if(p_i + 1 < plen){
					if(p.charAt(p_i+1)=='*'){
						for(; s_i < slen; s_i++){
							if(s.charAt(s_i) != p.charAt(p_i)){
								break;
							}
							if(isMatch(s.substring(s_i),p.substring(p_i+2))){
//								s_i += 1;
								break;
							}
						}
						p_i += 2;
						
					}else{
						if(p.charAt(p_i) == s.charAt(s_i)){
							p_i++;
							s_i++;
						}else
							return false;
					}
//					System.out.println(s_i +" "+p_i);
				}else{
					if(s_i + 1 == slen && s.charAt(s_i)==p.charAt(p_i))
						return true;
					else
						return false;
				}
			}
		}
    }
	
	public static void main(String[] args) {
		RegularExpressionMatching s = new RegularExpressionMatching();
		
		//System.out.println(s.isMatch("aaa", "aa"));
//		System.out.println(s.isMatch("aa", "a*"));
//		System.out.println(s.isMatch("aa", ".*"));
//		System.out.println(s.isMatch("ab", ".*"));
//		System.out.println(s.isMatch("aab", "c*a*b"));
//		System.out.println(s.isMatch("aaaab", "a*b"));
		//System.out.println("12345".substring(2));
//		System.out.println(s.isMatch("a", "a*a"));
//		System.out.println(s.isMatch("a", "ab*"));
//		System.out.println("1234$".indexOf('$'));
//		System.out.println(s.isMatch("bbbba", ".*a*a"));

	}

}
