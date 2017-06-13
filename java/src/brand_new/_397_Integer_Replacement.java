package brand_new;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _397_Integer_Replacement {
	public int integerReplacement(int n) {
		int length = 0;
		List<Long> list = new ArrayList<>();
		Set<Long> visited = new HashSet<>();
		list.add((long)n);
		visited.add((long)n);

		while (list.size() > 0) {
			List<Long> new_list = new ArrayList<>();
			for (Long i : list) {
				if (i == 1)
					return length;
				else if (i % 2 == 0) {
					if (!visited.contains(i / 2)) {
						new_list.add(i / 2);
						visited.add(i / 2);
					}
				} else {
					if (!visited.contains(i + 1)) {
						new_list.add(i + 1);
						visited.add(i + 1);
					}
					if (!visited.contains(i - 1)) {
						new_list.add(i - 1);
						visited.add(i - 1);
					}
				}
			}
			length++;
			list = new_list;
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.println(new _397_Integer_Replacement().integerReplacement(2147483647));
	}

}
