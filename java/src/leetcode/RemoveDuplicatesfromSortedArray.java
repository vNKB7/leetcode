package leetcode;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		else if(nums.length == 1){
			return 1;
		}
		
		int count = 1;
		
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i-1]){
				continue;
			}else{
				nums[count] = nums[i];
				count++;
			}
		}
		
		return count;
    }
	
	
	public static void main(String[] args) {
		int[] array = new int[]{1,1,2,3,3,4,5,6,6,6,7};
		int count = new RemoveDuplicatesfromSortedArray().removeDuplicates(array);
		System.out.println(count+"\n============");
		for(int x : array){
			System.out.println(x);
		}

	}

}
