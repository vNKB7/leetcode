package brand_new;

public class ZigZag_Conversion_6 {

	// public String convert(String s, int numRows) {
	// if(numRows == 1){
	// return s;
	// }
	// String result = "";
	// int length = s.length();
	// for (int i = 0; i < numRows; i++) {
	// for (int j = 0; j < length; j += 2 * numRows - 2) {
	// if ((i == 0 || i == numRows - 1) && (i + j < length)) {
	// result += s.charAt(i + j);
	// } else {
	// if (i + j < length) {
	// result += s.charAt(i + j);
	// }
	// if (j - i + 2 * numRows - 2 < length) {
	// result += s.charAt(j - i + 2 * numRows - 2);
	// }
	// }
	// }
	// }
	//
	// return result;
	// }

	

	public String convert(String s, int nRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();

		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++)
				// vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--)
				// obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}

	public static void main(String[] args) {
		System.out.println(new ZigZag_Conversion_6().convert("P", 1));
	}

}
