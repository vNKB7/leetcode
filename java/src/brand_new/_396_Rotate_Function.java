package brand_new;

public class _396_Rotate_Function {
	public int maxRotateFunction(int[] A) {
		int base = 0;
		int value = 0;
		int n = A.length;
		for(int i = 0; i < A.length; i++){
			base +=  A[i];
			value += A[i] * i;
		}
		
		int max = value;
		
		for(int i = n-1; i >= 0; i--){
			value += base - n * A[i];
			if(value > max)
				max = value;
		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new _396_Rotate_Function().maxRotateFunction(new int[]{4, 3, 2, 6}));
	}

}
