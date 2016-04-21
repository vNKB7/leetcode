package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rt = new ArrayList<List<Integer>>();
		
		if(nums == null || nums.length < 4){
			return rt;
		}
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 3; i++){
			
			if(i != 0 && nums[i-1] == nums[i]){
				continue;
			}
			
			for(int j = i+1; j < nums.length - 2; j++){
				
				if(j != i+1 && nums[j-1] == nums[j]){
					continue;
				}
				
				int l = j+1, r = nums.length-1;
				
				int sum = target - nums[i] - nums[j];
				
				while(l < r){
					int curSum = nums[l] + nums[r];
					
					if(sum == curSum){
						rt.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
			
						while(++l < r && nums[l-1] == nums[l]){
						
						}
						
						while(l < --r && nums[r] == nums[r+1]){
							
						}
						
					}else if(curSum > sum){
						r--;
					}else{
						l++;
					}
				}
			}
		}
		
		return rt;
    }
	
	
	public static void main(String[] args) {
		List<List<Integer>> result = new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		for(List<Integer> array : result){
			for(Integer n : array){
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}

}
