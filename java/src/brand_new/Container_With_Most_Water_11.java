package brand_new;

public class Container_With_Most_Water_11 {
	public int maxArea(int[] height) {
		int max_water = 0;
		int i = 0, j = height.length-1;
		while(i < j){
			int cur_water = (j-i)*Math.min(height[i], height[j]);
			if(cur_water > max_water){
				max_water = cur_water;
			}
			if(height[i] < height[j]){
				i++;
			}else{
				j--;
			}
		}
		return max_water;
	}
	

	public static void main(String[] args) {
		System.out.println(new Container_With_Most_Water_11().maxArea(new int[]{1,1}));
	}

}
