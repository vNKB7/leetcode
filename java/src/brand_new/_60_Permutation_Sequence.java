package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _60_Permutation_Sequence {
	
	public String getPermutation(int n, int k) {
		String result = "";
		List<Integer> list = new ArrayList<>();
		int f = 1;
		for(int i = 1; i <= n; i++){
			f *= i;
			list.add(i);
		}
		
		for(int i = n; i > 0; i--){
			f /= i;
			
			for(int j = 1; j <= list.size(); j++){
				if(k <= f * j){
					result += list.get(j-1)+"";
					list.remove(j-1);
					k -= f * (j - 1);
					break;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _60_Permutation_Sequence().getPermutation(3, 3));
	}

}
