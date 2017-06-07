package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _368_Largest_Divisible_Subset {
//  ver 1.0
//	public List<Integer> largestDivisibleSubset(int[] nums) {
//		List<Integer> result = new ArrayList<>();
//		if(nums.length == 0)
//			return result;
//		
//		List<List<Integer>> subSet = new ArrayList<>();
//		Arrays.sort(nums);
//		
//		
//		for(int num : nums){
//			boolean flag = false;
//			for(int i = subSet.size()-1; i >= 0; i--){
//				for(int t : subSet.get(i)){
//					if(num % t == 0){
//						if(i == subSet.size()-1){
//							subSet.add(new ArrayList<Integer>());
//						}
//						subSet.get(i+1).add(num);
//						flag = true;
//						break;
//					}
//				}
//				if(flag)
//					break;
//			}
//			if(!flag){
//				if(subSet.size() == 0){
//					subSet.add(new ArrayList<Integer>());
//				}
//				subSet.get(0).add(num);
//			}
//		}
//		
//		int cur = subSet.get(subSet.size()-1).get(0);
//		result.add(cur);
//		for(int i = subSet.size()-2; i >= 0; i--){
//			for(int t : subSet.get(i)){
//				if(cur % t == 0){
//					cur = t;
//					result.add(cur);
//				}
//			}
//		}
//		return result;
//	}

	
	//  ver 2.0
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int index = -1, max = 0;
		for(int i = 0; i < nums.length; i++){
			count[i] = 1;
			pre[i] = -1;
			for(int j = i-1; j >= 0; j--){
				if(nums[i] % nums[j] == 0){
					if(count[i] < count[j]+1){
						count[i] = count[j]+1;
						pre[i] = j;
					}
				}
			}
			
			if(count[i] > max){
				max = count[i];
				index = i;
			}
		}
		
		List<Integer> result = new ArrayList<>();
		while(index != -1){
			result.add(nums[index]);
			index = pre[index];
		}
		return result;
	}

	
	public static void main(String[] args) {
		System.out.println(new _368_Largest_Divisible_Subset().largestDivisibleSubset(new int[]{1,2,3,4,5,6,7,8}));
	}

}
