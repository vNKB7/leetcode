package leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        
        while(i < j){
        	int area = Math.min(height[i], height[j]) * (j-i);
        	
        	if(max < area)
        		max = area;
        	
        	if(height[i] < height[j]){
        		int t = i;
        		
        		while(t < j && height[t] <= height[i]){
        			t++;
        		}
        		
        		i = t;
        	}else{
        		int t = j;
        		
        		while(t > i && height[t] <= height[j]){
        			t--;
        		}
        		
        		j = t;
        	}
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
