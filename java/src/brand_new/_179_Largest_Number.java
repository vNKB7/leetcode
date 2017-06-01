package brand_new;

import java.util.Arrays;
import java.util.Comparator;

public class _179_Largest_Number {
	public String largestNumber(int[] nums) {
		String[] num = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			num[i] = nums[i] + "";
		}
		
		Arrays.sort(num, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.equals(o2))
					return 0;
				if(o1.length() > o2.length() || o1.length() == o2.length() && o1.compareTo(o2) >= 0){
					String t = o1;
					o1 = o2;
					o2 = t;
				}
				for(int i = 0; i < o1.length(); i++){
					if(o1.charAt(i) < o2.charAt(i))
						return 1;
					else if(o1.charAt(i) > o2.charAt(i))
						return -1;
				}
				if(o1.length() == o2.length())
					return 0;
				return o2.charAt(o1.length()) > o2.charAt(0) ? -1 : 1;
			}
		});
		String result = "";
		for(String s : num){
			System.out.println(s);
			result += s;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _179_Largest_Number().largestNumber(new int[] {26,33,19,29,61,66,52,37,7,76,89,93,72,2,82,11,9,41,47,76,80,28,86,30,99,25,99,85,96,98,88,33,4,94,25,80,19,55,82,71,29,61,15,2,57,98,15,91,27,95,47,38,66,2,78,26,77,33,23,90,73,27,20,5,38,23,35,29,13,46,6,71,58,37,89,28,8,1,8,73,81,83,77,22,63,36,62,89,94,43,25,86,53,21,94,9,40,19,24,21}));
	}

}
