package brand_new;

public class _394_Decode_String {
	// s = "3[a]2[bc]", return "aaabcbc".
	// s = "3[a2[c]]", return "accaccacc".
	// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

	public String decodeString(String s) {
		String result = "";

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z'){
				result += c;
				i++;
			}else {
				int nextLeft = s.indexOf('[', i);
				int nextRight = nextLeft + 1;
				int rightCount = 1;
				for(; nextRight < s.length(); nextRight ++){
					if(s.charAt(nextRight) == '[')
						rightCount ++;
					else if(s.charAt(nextRight) == ']')
						rightCount --;
					
					if(rightCount == 0)
						break;
				}
				
				
				int count = Integer.parseInt(s.substring(i, nextLeft));
				String subStr = decodeString(s.substring(nextLeft+1, nextRight));
				for(int j = 0; j < count; j ++){
					result += subStr;
				}
				i = nextRight + 1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _394_Decode_String().decodeString("2[abc]3[cd]ef"));
	}

}
