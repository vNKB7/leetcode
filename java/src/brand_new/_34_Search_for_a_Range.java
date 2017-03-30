package brand_new;

public class _34_Search_for_a_Range {

	public int[] searchRange(int[] nums, int target) {
		int[] range = new int[]{-1,-1};
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				int s = start, e = mid;
				while (s < e){
					int m = (s + e)/2;
					if(nums[m] == target){
						e = m - 1;
					}else{
						s = m + 1;
					}
				}
				if(nums[s] == target){
					range[0] = s;
				}else{
					range[0] = s+1;
				}
				
				s = mid;
				e = end;
				while (s < e){
					int m = (s + e)/2;
					if(nums[m] == target){
						s = m + 1;
					}else{
						e = m - 1;
					}
				}
				if(nums[e] == target){
					range[1] = e;
				}else{
					range[1] = e-1;
				}
				return range;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return range;
	}

	public static void main(String[] args) {
		int[] result = new int[2];
		result = new _34_Search_for_a_Range().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
		System.out.println(result[0] + " " + result[1]);
		

	}

}
