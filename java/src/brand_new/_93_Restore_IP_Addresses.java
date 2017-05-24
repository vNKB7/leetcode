package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _93_Restore_IP_Addresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() > 12)
			return result;
		backtrack(result, new ArrayList<Integer>(), s, 0);
		return result;

	}

	public void backtrack(List<String> result, List<Integer> prefix, String s,
			int index) {
		if (index == s.length()) {
			if (prefix.size() == 4) {
				result.add(String.format("%d.%d.%d.%d", prefix.get(0),
						prefix.get(1), prefix.get(2), prefix.get(3)));
			}
		}
		if((s.length() - index) > 3 * (4-prefix.size()))
			return;
		for (int i = index + 1; i <= s.length() && i <= index + 3; i++) {
			String field = s.substring(index, i);
			if (field.length() > 1 && field.charAt(0) == '0')
				continue;
			if (Integer.parseInt(field) <= 255) {
				prefix.add(Integer.parseInt(field));
				backtrack(result, prefix, s, i);
				prefix.remove(prefix.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new _93_Restore_IP_Addresses()
				.restoreIpAddresses("25525511135"));
	}

}
