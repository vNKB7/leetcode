package brand_new;

public class _415_Add_Strings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length()-1;
		int j = num2.length()-1;
		int c = 0;
		while (i >= 0 || j >= 0 || c > 0) {
			int a = i >= 0 ? num1.charAt(i) - '0' : 0;
			int b = j >= 0 ? num2.charAt(j) - '0' : 0;
			int div = (a + b + c) % 10;
			c = (a + b + c) / 10;
			sb.append(div);
			i--;
			j--;
		}
		sb.reverse();

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new _415_Add_Strings().addStrings("1", "9999999999999"));
	}

}
