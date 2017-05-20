package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), new boolean[nums.length], nums);
		return list;
	}

	public void backtrack(List<List<Integer>> list, List<Integer> prefix, boolean[] bitmap, int[] nums){
		if(nums.length == prefix.size()){
			list.add(new ArrayList<Integer>(prefix));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(!bitmap[i]){
					bitmap[i] = true;
					prefix.add(nums[i]);
					backtrack(list, prefix, bitmap, nums);
					prefix.remove(prefix.size()-1);
					bitmap[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
