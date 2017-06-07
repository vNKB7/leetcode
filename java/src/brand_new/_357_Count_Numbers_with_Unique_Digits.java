package brand_new;
//
//sum_k(=1...n)(A(k,10)-A(k-1,9)) + 1
//
public class _357_Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
		int[] factorial = new int[11];
		factorial[0] = 1;
		for(int i = 1; i <= 10; i++){
			factorial[i] = factorial[i-1] * i;
		}
		
		int result = 0;
		for(int i = 1; i <= n; i++){
			result += factorial[10]/factorial[10-i] - factorial[9]/factorial[10-i];
		}
		
		return result+1;
	}

	public static void main(String[] args) {
		System.out.println(new _357_Count_Numbers_with_Unique_Digits().countNumbersWithUniqueDigits(3));
	}

}
