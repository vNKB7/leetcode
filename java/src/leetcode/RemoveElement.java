package leetcode;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int count = 0;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[count] = nums[i];
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
