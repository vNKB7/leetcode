package leetcode;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if (num1.length() > num2.length()) {
			String tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		// (num1.length <= num2.length) always true
		
		String result = "";
		
		
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("0", "0"));
	}
}



//public class MultiplyStrings {
//
//	public String multiply(String num1, String num2) {
//		if (num1.length() > num2.length()) {
//			String tmp = num1;
//			num1 = num2;
//			num2 = tmp;
//		}
//		// (num1.length <= num2.length) always true
//		
//		num1 = new StringBuffer(num1).reverse().toString();
//		
//		String result = "";
//		
//		for(int i = 0; i < num1.length(); i++){
//			String tmp = subMult(num2, num1.charAt(num1.length() - i - 1));
//			
//			result = plus(tmp, result+"0");
//		}
//		
//		return result;
//	}
//	
//	String subMult(String num1, char num2){
//		String result = "0";
//		
//		for(int i = 0; i < num2-'0'; i++){
//			result = plus(result, num1);
//		}
//		
//		return result;
//	}
//
//	String plus(String num1, String num2) {
//		StringBuilder sb = new StringBuilder();
//
//		num1 = new StringBuffer(num1).reverse().toString();
//		num2 = new StringBuffer(num2).reverse().toString();
//		
//		int carry = 0;
//
//		if (num1.length() > num2.length()) {
//			String tmp = num1;
//			num1 = num2;
//			num2 = tmp;
//		}
//		// (num1.length <= num2.length) always true
//
//		for (int i = 0; i < num1.length(); i++) {
//			int sum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
//
//			carry = sum / 10;
//			int reminder = sum % 10;
//			sb.insert(0, (char)(reminder + '0'));
//		}
//
//		for(int i = num1.length(); i < num2.length(); i++){
//			int sum = num2.charAt(i) - '0' + carry;
//
//			carry = sum / 10;
//			int reminder = sum % 10;
//			sb.insert(0, (char)(reminder + '0'));
//		}
//		
//		if(carry == 1){
//			sb.insert(0, 1);
//		}
//		
//		
//		return sb.toString();
//	}
//
//	public static void main(String[] args) {
//		System.out.println(new MultiplyStrings().multiply("0", "0"));
//
//		
//	}
//
//}
