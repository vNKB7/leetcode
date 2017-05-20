package brand_new;

public class _42_Trapping_Rain_Water {
	public int trap(int[] height) {
		if(height.length == 0)
			return 0;
		int max_height = height[0];
		int max_index = 0;
		int local_height = 0;
		int local_index = 0;
		int area = 0;

		for (int i = 1; i < height.length; i++) {
			if (height[i] >= max_height) {
				int h = height[i] < max_height ? height[i] : max_height;
				for (int j = max_index + 1; j <= i - 1; j++) {
					area += h - height[j];
				}
				max_height = height[i];
				max_index = i;
				local_height = 0;
				local_index = -1;
			} else if (height[i - 1] < height[i] && height[i] > local_height) {
				local_height = height[i];
				local_index = i;
			}
		}

		if (max_index != height.length - 1 && local_index != -1) {
			for(int j = max_index + 1; j <= local_index -1; j++){
				area += local_height > height[j] ? local_height - height[j] : 0;
			}
		}
		
		return area;
	}

	public static void main(String[] args) {
		System.out.println(new _42_Trapping_Rain_Water().trap(new int[]{9,6,8,8,5,6,3}));
	}
}
