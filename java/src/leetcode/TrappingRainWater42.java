package leetcode;

import java.util.ArrayList;

public class TrappingRainWater42 {

	public int trap(int[] height) {
		if(height == null || height.length == 0){
			return 0;
		}
		return cut(height, 0, height.length-1);
	}

	int cut(int[] height, int start, int end){
		for(; start < end; start++){
			if(height[start] > height[start+1])
				break;
		}
		
		for(; start < end; end --){
			if(height[end] > height[end-1])
				break;
		}
		
		int minOfTwo = height[start]<height[end]?height[start]:height[end];
		
		int max = -1;
		int maxIndex = -1;
		for(int i = start+1; i < end; i++){
			if(height[i] > max){
				max = height[i];
				maxIndex = i;
			}
		}
		if(max > minOfTwo){
			return cut(height, start, maxIndex) + cut(height, maxIndex, end);
		}
		
		int volumn = 0;
		for(int i = start+1; i < end; i++){
			volumn += minOfTwo - height[i];
		}
		
		return volumn;
	}

	public static void main(String[] args) {
		System.out.println(new TrappingRainWater42().trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));

	}
}
