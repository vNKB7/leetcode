package brand_new;

public class _62_Unique_Paths {
	
	public int uniquePaths(int m, int n) {
		int max = m > n ? m : n;
		int min = m < n ? m : n;
		int[] F = new int[min];
		F[min-1] = 1;
		for(int i = 0; i < max; i++){
			for(int j = min-1; j >= 0; j--){
				if(j != min-1){
					F[j] += F[j+1];
				}
			}
		}
		
		return F[0];
	}

	public static void main(String[] args) {
		System.out.println(new _62_Unique_Paths().uniquePaths(50, 50));
	}

}
