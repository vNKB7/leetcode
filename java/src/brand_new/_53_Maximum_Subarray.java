package brand_new;

public class _53_Maximum_Subarray {
	
	public int maxSubArray(int[] nums) {
		int global = Integer.MIN_VALUE, local = nums[0];
		
		for(int i = 0; i < nums.length; i++){
			local += nums[i];
			
			if(local > global)
				global = local;
			
			if(local < 0)
				local = 0;
		}
		
		return global;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
