package brand_new;


public class _390_Elimination_Game {

//	public int lastRemaining(int n) {
//		int k = 0, tmp = n;
//		while (tmp > 1) {
//			k++;
//			tmp /= 2;
//		}
//		for(int i = 1; i <= n; i++)
//			if (!isRemoved(i, n, k))
//				return i;
//		return 0;
//	}
//
//	public boolean isRemoved(int i, int n, int k) {
//		boolean s = true;
//		for (int c = 0; c < k; c++) {
//			if (s) {
//				if (i % 2 == 1)
//					return true;
//			} else {
//				if (n % 2 == 1) {
//					if (i % 2 == 1)
//						return true;
//				} else if (i % 2 == 0)
//					return true;
//			}
//			i = (i+1)/2;
//			n = n / 2;
//			s = !s;
//		}
//		return false;
//	}

//	public static void main(String[] args) {
//		System.out.println(new _390_Elimination_Game().lastRemaining(1000000000));
//	}

}
