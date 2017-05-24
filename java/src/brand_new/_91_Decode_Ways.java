package brand_new;

public class _91_Decode_Ways {
// 好像不对，但通过了测试
//	public int numDecodings(String s) {
//		if(s.length() == 0)
//			return 0;
//		int[] DP = new int[s.length()+2];
//		DP[0] = 1;
//		DP[1] = 1;
//		DP[2] = s.charAt(0) == '0' ? 0 : 1;
//		for (int i = 3; i < DP.length; i++) {
//			if (s.charAt(i - 2) != '0')
//				DP[i] += DP[i - 1];
//
//			if (Integer.parseInt(s.substring(i - 3, i - 1)) <= 26) {
//				DP[i] += DP[i - 2];
//			}
//		}
//		return DP[DP.length - 1];
//	}
	
	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		s = "00" + s;
		int[] DP = new int[s.length()];
		DP[0] = 1;
		DP[1] = 1;

		for (int i = 2; i < DP.length; i++) {
			if (s.charAt(i) != '0')
				DP[i] += DP[i - 1];

			if (s.charAt(i - 1) != '0') {
				int p = Integer.parseInt(s.substring(i - 1, i + 1));
				if (p <= 26 && p > 0) {
					DP[i] += DP[i - 2];
				}
			}
		}
		return DP[DP.length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new _91_Decode_Ways().numDecodings("0"));

	}
}
