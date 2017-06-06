package brand_new;

import java.util.Arrays;

public class _274_H_Index {
	public int hIndex(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		for (int i = 0; i < n; i++){
			if(n-i <= citations[i])
				return n-i;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new _274_H_Index().hIndex(new int[] { 4, 4, 0, 0 }));
	}
}
