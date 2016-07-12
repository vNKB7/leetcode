package leetcode;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		for(int i = 0; i < nums.length; i++){
			while(true){
				if(nums[i] == i+1)
					break;
				
				if(nums[i] > 0 && nums[i] < nums.length){
					int tmp = nums[i];
					nums[i] = nums[tmp-1];
					nums[tmp-1] = tmp;
				}else{
					break;
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != i+1)
				return i+1;
		}
		
		return nums.length+1;
	}

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
	}

}
