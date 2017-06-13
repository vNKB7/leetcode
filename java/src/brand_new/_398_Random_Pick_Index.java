package brand_new;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class _398_Random_Pick_Index {
	int[] nums;
	int[] sequence;
	Map<Integer, int[]> map = new HashMap<>();
	Random rd = new Random();
	
	public _398_Random_Pick_Index(int[] nums) {
		this.nums = nums;
		Map<Integer, Integer> lastIndex = new HashMap<>();
		sequence = new int[nums.length];
		Arrays.fill(sequence, -1);
		
		for(int i = 0; i < nums.length; i++){
			if(lastIndex.containsKey(nums[i])){
				sequence[lastIndex.get(nums[i])] = i;
				lastIndex.put(nums[i], i);
				map.get(nums[i])[1]++;
			}else{
				lastIndex.put(nums[i], i);
				map.put(nums[i], new int[]{i, 1});
			}
		}
	}

	public int pick(int target) {
		int index = map.get(target)[0];
		int size = map.get(target)[1];
		int pick = 0;
		for(int i = 0; i < size; i++){
			if(i == rd.nextInt(i+1))
				pick = index;
			index = sequence[index];
		}
		return pick;
	}

	public static void main(String[] args) {
		_398_Random_Pick_Index obj = new _398_Random_Pick_Index(new int[]{1,2,3,3,3});
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			System.out.println(obj.pick(in.nextInt()));
		}
	}

}
