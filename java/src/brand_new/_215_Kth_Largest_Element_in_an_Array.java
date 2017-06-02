package brand_new;

import java.util.Random;

public class _215_Kth_Largest_Element_in_an_Array {
	Random rd = new Random();

	public int findKthLargest(int[] nums, int k) {
		return randomSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	public int randomSelect(int[] nums, int i, int j, int k) {
		int p = rd.nextInt(j - i + 1);
		int tmp = nums[j];
		nums[j] = nums[i + p];
		nums[i + p] = tmp;
		int povit = patition(nums, i, j);
		if (povit == k)
			return nums[povit];
		else if (povit > k)
			return randomSelect(nums, i, povit - 1, k);
		else
			return randomSelect(nums, povit + 1, j, k);
	}

	public int patition(int[] nums, int start, int end) {
		int i = start - 1;
		int j = start;
		int x = nums[end];

		for (; j < end; j++) {
			if (nums[j] <= x) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}

		i++;
		nums[end] = nums[i];
		nums[i] = x;
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println(new _215_Kth_Largest_Element_in_an_Array().findKthLargest(new int[]{3,1,2,4}, 2));
	}

}
