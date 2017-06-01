package brand_new;

public class _152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;

		int local_max = nums[0];
		int local_min = nums[0];
		int global_max = nums[0];
		
		for(int i = 1; i < nums.length; i++){
			int t = local_max;
			local_max = Math.max(nums[i], Math.max(local_max * nums[i], local_min * nums[i]));
			local_min = Math.min(nums[i], Math.min(t * nums[i], local_min * nums[i]));
			if(local_max > global_max)
				global_max = local_max;
		}
		return global_max;
	}

	public static void main(String[] args) {
		System.out.println(new _152_Maximum_Product_Subarray()
				.maxProduct(new int[] {-2,4,-2}));
	}
}
