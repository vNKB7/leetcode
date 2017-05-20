package brand_new;

public class _26_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int slow = 0, fast = 0;
		while(fast < nums.length){
			if(fast == 0 || nums[fast] != nums[fast-1]){
				nums[slow] = nums[fast];
				slow ++;
			}
			fast ++;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
