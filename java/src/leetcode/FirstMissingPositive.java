package leetcode;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int end = nums.length;
		int index = 0;
		
		while(index < end){
			if(nums[index] == index + 1){
				index ++;
			}else if(nums[index] <= 0 || nums[index] >= end){
				int tmp = nums[index];
				nums[index] = nums[end - 1];
				nums[end - 1] = tmp;
				end --;
				continue;
			}else{
				if(nums[nums[index]-1] == nums[index]){
					int tmp = nums[index];
					nums[index] = nums[end - 1];
					nums[end - 1] = tmp;
					end --;
					continue;
				}else{
					int tmp = nums[index];
					nums[index] = nums[tmp-1];
					nums[tmp-1] = tmp;
					continue;
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != i+1){
				return i+1;
			}
		}
		
		return nums.length+1;
	}

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1,1,2}));
	}

}
