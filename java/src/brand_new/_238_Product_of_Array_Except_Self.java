package brand_new;

public class _238_Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
		int mul = 1;
		int zero = 0;
		for (int i : nums) {
			if (i == 0) {
				zero++;
			} else {
				mul *= i;
			}
		}

		if (zero > 1) {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = 0;
			}
		} else if (zero == 1) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0)
					nums[i] = mul;
				else
					nums[i] = 0;

			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = mul / nums[i];
			}
		}
		return nums;
	}
}
