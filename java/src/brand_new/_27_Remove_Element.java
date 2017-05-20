package brand_new;

public class _27_Remove_Element {

	public int removeElement(int[] nums, int val) {
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
