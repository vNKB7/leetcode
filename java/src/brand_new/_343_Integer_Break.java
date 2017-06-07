package brand_new;

public class _343_Integer_Break {
	public int integerBreak(int n) {
		if(n > 3) n++;
		
		int[] cost = new int[n];
		cost[0] = 1;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				cost[i] = Math.max(cost[j] * (i-j), cost[i]);
			}
		}

		return cost[n-1];
	}

	public static void main(String[] args) {
		System.out.println(new _343_Integer_Break().integerBreak(10));
	}

}
