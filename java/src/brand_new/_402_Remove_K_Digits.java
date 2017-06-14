package brand_new;

public class _402_Remove_K_Digits {
	public String removeKdigits(String num, int k) {
		StringBuilder sb = new StringBuilder(num);
		
		int index = 1;
		while(index < sb.length() && k > 0){
			if(sb.charAt(index-1) > sb.charAt(index)){
				int i = index - 1;
				for(; i >= 0 && k > 0; i--){
					if(sb.charAt(i) > sb.charAt(index)){
						k--;
					}else{
						break;
					}
				}
				sb.delete(i+1, index);
				index = i+2;
			}else{
				index ++;
			}
		}

		if(k >= sb.length())
			return "0";
		sb = new StringBuilder(sb.substring(0, sb.length()-k));
		
		index = 0;
		while(index < sb.length()){
			if(sb.charAt(index) != '0')
				break;
			index++;
		}
		
		return sb.substring(index).length() == 0 ? "0" : sb.substring(index);
	}
	
//	public StringBuilder helper(StringBuilder sb, int k){
//		StringBuilder result = new StringBuilder();
//		if(sb.length() <= k)
//			return result;
//		
//		int min = 10;
//		int min_index = -1;
//		for(int i = 1; i <= k; i++){
//			
//		}
//		
//		return result;
//	}

	public static void main(String[] args) {
		System.out.println(new _402_Remove_K_Digits().removeKdigits("112", 1));
	}

}
