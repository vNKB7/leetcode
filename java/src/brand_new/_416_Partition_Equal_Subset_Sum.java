package brand_new;

public class _416_Partition_Equal_Subset_Sum {
	
//	Each of the array element will not exceed 100.
//	The array size will not exceed 200.
	
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int i : nums)
			sum += i;
		if(sum % 2 == 1)
			return false;
		
		sum /= 2;
		
		boolean[] DP = new boolean[sum+1];
		DP[0] = true;
		
		for(int i = 0; i < nums.length; i++){
			for(int j = sum; j >= nums[i]; j--){
				DP[j] = DP[j] || DP[j-nums[i]];
			}
		}
		
		return DP[sum];
	}

	public static void main(String[] args) {
		System.out.println(new _416_Partition_Equal_Subset_Sum().canPartition(new int[]{1, 11, 3, 5}));
	}

}
