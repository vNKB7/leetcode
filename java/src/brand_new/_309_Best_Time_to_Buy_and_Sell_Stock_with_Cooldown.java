package brand_new;

public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
// ver 1.0
//	public int maxProfit(int[] prices) {
//		if(prices == null || prices.length == 0)
//      	return 0;
//		int n = prices.length;
//		int[] B = new int[n];
//		int[] S = new int[n];
//		int[] C = new int[n];
//		B[0] = -prices[0];
//		
//		for(int i = 1; i < n; i++){
//			C[i] = Math.max(S[i-1], C[i-1]);
//			B[i] = Math.max(C[i-1] - prices[i], B[i-1]);
//			S[i] = B[i-1] + prices[i];
//		}
//		return Math.max(S[n-1], C[n-1]);
//	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
            return 0;
		
		int n = prices.length;
		int B = -prices[0], S=0, C=0;
		
		for(int i = 1; i < n; i++){
			int C1 = Math.max(S, C);
			int B1 = Math.max(C - prices[i], B);
			int S1 = B + prices[i];
			C = C1;
			B = B1;
			S = S1;
		}
		return Math.max(S, C);
	}

	public static void main(String[] args) {
		System.out.println(new _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown().maxProfit(new int[]{1,2,3,0,9,2,4,5,1,4,2}));
	}

}
