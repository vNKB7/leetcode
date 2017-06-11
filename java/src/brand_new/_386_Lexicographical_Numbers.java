package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _386_Lexicographical_Numbers {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		helper(result, 0, n);
		return result;
	}

	public void helper(List<Integer> result, int pre, int n) {
		pre = pre * 10;
		for (int i = pre == 0 ? 1 : 0; i <= 9; i++) {
			if (pre + i > n)
				return;
			result.add(pre + i);
			helper(result, pre + i, n);
		}
	}

	public static void main(String[] args) {
		System.out.println(new _386_Lexicographical_Numbers().lexicalOrder(13));
	}

}
