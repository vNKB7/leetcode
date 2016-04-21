package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	/*8ms
	 * 96%
	 */
	
	public int threeSumClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		
		int closest = Integer.MAX_VALUE;
		int num = 0;
		
		for(int i = 0; i < nums.length - 2; i++){
			
			int l = i + 1, r = nums.length - 1;
			
			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			
			while(l < r){
				
				int offest = target - (nums[i] + nums[l] + nums[r]);
				
				if(offest == 0){
					return target;
				}else if(offest > 0){
					if(closest > offest){
						closest = offest;
						num = target - offest;
					}
					
					l++;
				}else{
					if(closest > -offest){
						closest = -offest;
						num = target - offest;
					}
					
					r--;
				}
			}
		}
		
		return num;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0, 1, 2}, 3));
	}

}
