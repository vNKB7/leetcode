package brand_new;

public class _164_Maximum_Gap {
	
	public int maximumGap(int[] nums) {
		if(nums == null || nums.length <= 1){
			return 0;
		}
		
		long leftEnd = Math.min(nums[0], nums[1]);
		long rightEnd = Math.max(nums[0], nums[1]);
		long maxGap = rightEnd - leftEnd;
		
		for(int i = 2; i < nums.length; i++){
			if(nums[i] > rightEnd){
				if(nums[i] - rightEnd > maxGap){
					maxGap = nums[i] - rightEnd;
				}
				rightEnd = nums[i];
			}else if(nums[i] < leftEnd){
				if(leftEnd - nums[i] > maxGap){
					maxGap = leftEnd - nums[i];
				}
				leftEnd = nums[i];
			}
		}

		return (int) maxGap;
	}

	public static void main(String[] args) {
		System.out.println(new _164_Maximum_Gap().maximumGap(new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}));
	}
}
