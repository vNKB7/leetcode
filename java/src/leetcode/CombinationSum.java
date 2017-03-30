package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		
		findSubSolution(result, candidates, target, 0, new ArrayList<Integer>(), 0);
		
		return result;
	}
	
	void findSubSolution(List<List<Integer>> list, int[] candidates, int target, int index, List<Integer> pre, int preSum){
		for(int i = index; i < candidates.length; i++){
			if(preSum + candidates[i] == target){
				pre.add(candidates[i]);
				list.add(new ArrayList<Integer>(pre));
				pre.remove(pre.size() - 1);
			}else if(preSum + candidates[i] < target){
				pre.add(candidates[i]);
				findSubSolution(list, candidates, target, i, pre, preSum+candidates[i]);
				pre.remove(pre.size() - 1);
			}else{
				break;
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73}, 310);

		for(int i = 0; i < result.size(); i++){
			List<Integer> tmp = result.get(i);
			
			for(int j = 0; j < tmp.size(); j++){
				System.out.print(tmp.get(j)+" ");
			}
			System.out.println();
		}
	}

}
