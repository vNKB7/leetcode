package brand_new;

public class _55_Jump_Game {
	public boolean canJump(int[] nums) {
		int p1 = 1, p2 = 0;
		for(int i = 0; i < nums.length; i++){
			if(i == p1){
				if(p2 == p1)
					return false;
				else
					p1 = p2;
			}
			
			int next = i + nums[i] + 1;
			p2 = p2 > next ? p2 : next;
		}
		return p2 >= nums.length;
	}

	public static void main(String[] args) {
		System.out.println(new _55_Jump_Game().canJump(new int[]{10,9,8,7,6,5,4,3,2,1,0,1}));
	}

}
