package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (nums.length < 3) {
			return rt;
		}

		Arrays.sort(nums);

		int lasti = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			int p = i + 1, q = nums.length - 1;

			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}


			while (p < q) {
				int sum = nums[i] + nums[p] + nums[q];
				
				if (sum == 0) {
					rt.add(Arrays.asList(nums[i], nums[p], nums[q]));
					
					while(++p < q && nums[p-1] == nums[p]){
					}
					
					while(p < --q && nums[q] == nums[q+1]){
					}
					
				} else if (sum > 0) {
					q--;
				} else {
					p++;
				}
			}
		}
		
		return rt;
	}

	public static void main(String args[]) {
		int[] nums = new int[] {-8, 4, 4, 4, 4};

		List<List<Integer>> result = new ThreeSum().threeSum(nums);

		for (List<Integer> triple : result) {
			for (Integer t : triple) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
}
