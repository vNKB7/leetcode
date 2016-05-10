package leetcode;

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (haystack.length() == 0 && needle.length() == 0) {
			return 0;
		}

		int index = 0;

		int subLen = needle.length();

		for (index = 0; index < haystack.length() - subLen + 1; index++) {
			if (haystack.substring(index, index + subLen).equals(needle)) {
				return index;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new ImplementstrStr().strStr("123456", "34"));

	}

}
