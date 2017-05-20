package brand_new;

public class _50_Pow_x_n {
	
	public double myPow(double x, int n) {
		double result = 1;
		long absN = Math.abs((long)n); // int的负值比正值多一个
		
		while(absN > 0){
			if((absN & 1) == 1){
				result *= x;
			}
			absN >>= 1;
			x *= x;
		}
		
		return n >= 0 ? result : 1/result;
	}

	public static void main(String[] args) {
		System.out.println(new _50_Pow_x_n().myPow(2.00000, -2147483648));
	}

}
