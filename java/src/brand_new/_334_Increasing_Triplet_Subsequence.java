package brand_new;

public class _334_Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		
		int one = nums[0];
		int two = Integer.MAX_VALUE;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > two)
				return true;
			else if (nums[i] > one)
				two = nums[i];
			else
				one = nums[i];
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{4,5,3,2}));
	}

}
