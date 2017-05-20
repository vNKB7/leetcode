package brand_new;

public class _41_First_Missing_Positive {

	public int firstMissingPositive(int[] nums) {
		if(nums.length == 0){
			return 1;
		}
		
		int first = 0, end = nums.length;
		while (first < end) {
			if (first+1 != nums[first]) {
				if (nums[first] < end+1 && nums[first] > 0 && nums[first] != nums[nums[first]-1]) {
					swap(nums, first, nums[first]-1);
				} else {
					swap(nums, first, end-1);
					end--;
				}
			} else {
				first++;
			}
		}
		
		if(first >= nums.length){
			return nums.length+1;
		}else if(nums[first] == first+1){
			return first + 1 + 1;
		}else{
			return first + 1;
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(new _41_First_Missing_Positive().firstMissingPositive(new int[]{1,1}));
	}

}
