package brand_new;

public class _342_Power_of_Four {
	static int base = 1;
	static {
		for (int i = 0; i < 32; i += 2) {
			base <<= 2;
			base |= 1;
		}
	}
//ver 1.0
//	public boolean isPowerOfFour(int num) {
//		return (num & ~base) == 0 && Integer.bitCount(num & base) == 1;
//	}
	
	//ver 2.0
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & -1431655766) == 0 && (num&(num-1)) == 0;
	}


// 何等神奇的答案
//	public boolean isPowerOfFour(int num) {
//        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
//        //0x55555555 is to get rid of those power of 2 but not power of 4
//        //so that the single 1 bit always appears at the odd position 
//    }
	
	public static void main(String[] args) {
		System.out.println(new _342_Power_of_Four().isPowerOfFour(256));
	}
}
