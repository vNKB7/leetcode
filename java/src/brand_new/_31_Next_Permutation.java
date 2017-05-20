package brand_new;

import java.util.Arrays;

public class _31_Next_Permutation {
//	public void nextPermutation(int[] nums) {
//		int index = nums.length-1;
//		boolean flag = false;
//		for(int i = nums.length-2; i >= 0; i--){
//			if(nums[i] < nums[i+1]){
//				index = i;
//				flag = true;
//				break;
//			}
//		}
//		if(!flag){
//			reverse(nums, 0, nums.length-1);
//			return;
//		}else{
//			int min = Integer.MAX_VALUE;
//			int min_index = index;
//			for(int i = index+1; i < nums.length; i++){
//				if(nums[index] < nums[i] && nums[i] <= min){
//					min_index = i;
//					min = nums[i];
//				}
//			}
//			int tmp = nums[index];
//			nums[index] = nums[min_index];
//			nums[min_index] = tmp;
//			
//			reverse(nums, index+1, nums.length - 1);
//		}
//		
//	}
//	
//	public void reverse(int[] nums, int start, int end){
//		while(start < end){
//			int tmp = nums[start];
//			nums[start] = nums[end];
//			nums[end] = tmp;
//			start ++;
//			end --;
//		}
//	}
	
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length < 2)
			return ;
		
		int i = nums.length -2;
		for(; i >= 0; i--){
			if(nums[i] < nums[i+1])
				break;
		}

		if(i < 0){
			Arrays.sort(nums);
			return;
		}
		
		int j = nums.length - 1;
		for(; j >= 0; j--){
			if(nums[i] < nums[j]){
				break;
			}
		}
		
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		
		Arrays.sort(nums, i+1, nums.length);
	}
	

	public static void main(String[] args) {
		int[] b = new int[]{4,3,2,1};
		new _31_Next_Permutation().nextPermutation(b);
		for(int i : b)
			System.out.println(i);
		
	}

}
