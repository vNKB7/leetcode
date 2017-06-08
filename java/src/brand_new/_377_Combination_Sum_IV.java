package brand_new;

public class _377_Combination_Sum_IV {
	public int combinationSum4(int[] nums, int target) {
		int[] DP = new int[target + 1];
		DP[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j : nums) {
				if (i - j >= 0)
					DP[i] += DP[i - j];
			}
		}
		return DP[target];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
