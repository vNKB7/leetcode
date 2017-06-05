package brand_new;

public class _299_Bulls_and_Cows {
	public String getHint(String secret, String guess) {
		int len = secret.length();
		int[] countB = new int[10];
		int countA = 0;
		for (int i = 0; i < len; i++) {
			char a = secret.charAt(i);
			char b = guess.charAt(i);
			if (a == b)
				countA++;
			else
				countB[secret.charAt(i) - '0']++;
		}
		
		for (int i = 0; i < len; i++) {
			char a = secret.charAt(i);
			char b = guess.charAt(i);
			if(a == b)
				continue;
			else{
				if(countB[guess.charAt(i) - '0'] > 0)
					countB[guess.charAt(i) - '0']--;
			}
		}

		int countC = 0;
		for (int i : countB)
			countC += i;

		return String.format("%dA%dB", countA, len-countA-countC);
	}

	public static void main(String[] args) {
		System.out.println(new _299_Bulls_and_Cows().getHint("0", "1"));
	}

}
