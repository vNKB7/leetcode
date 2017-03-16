package brand_new;

public class String_to_Integer_8 {
	public int myAtoi(String str) {
		int result = 0;
		int sign = 1;
		int index = 0;
		for(;index < str.length(); index++){
			if(str.charAt(index) != ' '){
				break;
			}
		}
		if(index == str.length()){
			return 0;
		}
		if(str.charAt(index) == '-'){
			sign = -1;
			index ++;
		}else if(str.charAt(index) == '+'){
			sign = 1;
			index ++;
		}else if(str.charAt(index)-'0'<0 || str.charAt(index)-'0'>9){
			return 0;
		}
		
		while(index < str.length() && str.charAt(index)-'0' >= 0 && str.charAt(index)-'0' <= 9){
			if(sign == 1 && (result > 214748364 || result == 214748364 && str.charAt(index)-'0' > 7)){
				return 2147483647;
			}else if(sign == -1 && (result > 214748364 || result == 214748364 && str.charAt(index)-'0' > 8)){
				return -2147483648;
			}
			result = result * 10 + (str.charAt(index)-'0');
			index ++;
		}
		
		return result * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new String_to_Integer_8().myAtoi(""));
	}

}
