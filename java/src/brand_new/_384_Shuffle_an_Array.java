package brand_new;

import java.util.Arrays;
import java.util.Random;

public class _384_Shuffle_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {

	Random rd = new Random();
	int[] nums;

	public Solution(int[] nums) {
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return Arrays.copyOf(nums, nums.length);
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] shuffled = Arrays.copyOf(nums, nums.length);
		for(int i = 0; i < shuffled.length; i++){
			swap(shuffled, i, rd.nextInt(shuffled.length));
		}
		return shuffled;
	}
	
	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}