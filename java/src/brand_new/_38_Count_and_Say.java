package brand_new;

public class _38_Count_and_Say {
	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for(int i = 0; i < n-1; i++){
			sb = helper(sb);
		}
		return sb.toString();
	}

	public StringBuilder helper(StringBuilder sb) {
		int count = 0;
		char c = '*';
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != c) {
				result.append(count);
				result.append(c);
				count = 1;
				c = sb.charAt(i);
			} else
				count++;
		}
		
		if(count > 0){
			result.append(count);
			result.append(c);
		}
		return new StringBuilder(result.substring(2));
	}

	public static void main(String[] args) {
		_38_Count_and_Say instance = new _38_Count_and_Say();
//		for(int i = 0; i < 30; i++){
//			System.out.println(instance.countAndSay(i));
//		}
		System.out.println(instance.countAndSay(29));
	}

}
