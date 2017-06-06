package brand_new;

import java.util.Arrays;

public class _322_Coin_Change {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int[] M = new int[amount + 1];
		for (int i = 1; i < amount + 1; i++)
			M[i] = amount + 1;

		Arrays.sort(coins);

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < amount + 1; j++) {
				M[j] = Math.min(M[j - coins[i]] + 1, M[j]);
			}
		}
		
		
		return M[amount] > amount ? -1 : M[amount];
	}

	public static void main(String[] args) {
		System.out.println(new _322_Coin_Change().coinChange(new int[] { 1, 2,
				5 }, 11));
	}

}
