package brand_new;

public class _43_Multiply_Strings {
	public String multiply(String num1, String num2) {

	}

	public String add(String a, String b) {
		String result = "";
		int c = 0;
		int length = Math.max(a.length(), b.length());
		for(int i = 0; i < length; i++){
			int indexa = a.length() - i - 1;
			int indexb = b.length() - i - 1;
			int numa = indexa >= 0? a.charAt(indexa)-'0':0;
			int numb = indexb >= 0?b.charAt(indexb)-'0':0;
			result = Character((numa+numb+c)%10 + '0') + result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
