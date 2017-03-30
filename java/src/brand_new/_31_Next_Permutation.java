package brand_new;

public class _31_Next_Permutation {
	public void nextPermutation(int[] nums) {
		int index = nums.length-1;
		boolean flag = false;
		for(int i = nums.length-2; i >= 0; i--){
			if(nums[i] < nums[i+1]){
				index = i;
				flag = true;
				break;
			}
		}
		if(!flag){
			reverse(nums, 0, nums.length-1);
			return;
		}else{
			int min = Integer.MAX_VALUE;
			int min_index = index;
			for(int i = index+1; i < nums.length; i++){
				if(nums[index] < nums[i] && nums[i] <= min){
					min_index = i;
					min = nums[i];
				}
			}
			int tmp = nums[index];
			nums[index] = nums[min_index];
			nums[min_index] = tmp;
			
			reverse(nums, index+1, nums.length - 1);
		}
		
	}
	
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start ++;
			end --;
		}
	}
	

	public static void main(String[] args) {
		int[] b = new int[]{2,3,1,3,3};
		new _31_Next_Permutation().nextPermutation(b);
		for(int i : b)
			System.out.println(i);
		
	}

}
