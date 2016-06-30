package leetcode;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1)
			return;
		
		int nums_length = nums.length;
		
		int i = nums_length - 2;
		for(; i >= 0; i--){
			if(nums[i] < nums[i+1]){
				int tmp = nums[i];
				
				for(int j = nums_length-1; j > i; j--){
					if(nums[j] > tmp){
						nums[i] = nums[j];
						nums[j] = tmp;
						break;
					}
				}
				
				break;
			}
		}
		
		sort(nums, i+1, nums_length);
	}
	
	void sort(int[] nums, int i, int j){
		j --;
		while(i < j){
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,1};
		new NextPermutation().nextPermutation(nums);
		for(int num : nums){
			System.out.print(num+" ");
		}
		System.out.println();
	}

}
