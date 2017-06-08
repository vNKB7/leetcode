package brand_new;

public class _372_Super_Pow {
//  ver 1.0
//	public int superPow(int a, int[] b) {
//		if (a == 1337)
//			return 0;
//		else if (a > 1337) {
//			a %= 1337;
//		}
//		if (isZero(b)) {
//			return 1;
//		}
//		
//		int c = divide2(b);
//		return ((c == 0 ? 1 : a) * superPow((a * a) % 1337, b)) % 1337;
//	}
//
//	public int divide2(int[] b) {
//		int c = 0;
//		for (int i = 0; i < b.length; i++) {
//			int d = c * 10 + b[i];
//			c = d % 2;
//			b[i] = d / 2;
//		}
//		return c;
//	}
//
//	public boolean isZero(int[] b) {
//		for (int i = 0; i < b.length; i++)
//			if (b[i] != 0)
//				return false;
//		return true;
//	}
	
	
	// ver 2.0
	final int base = 1337;
	
	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length-1);
	}
	
	public int superPow(int a, int[] b, int index) {
		if(index < 0)
			return 1;
		return pow(superPow(a, b, index-1), 10) * pow(a, b[index]) % base;
	}
	
	
	public int pow(int a, int k){
		a = a % base;
		int result = 1;
		for(int i = 0; i < k; i++){
			result = result * a % base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new _372_Super_Pow().superPow(2, new int[]{0}));
	}
}
