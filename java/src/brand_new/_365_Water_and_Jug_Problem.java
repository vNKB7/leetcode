package brand_new;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _365_Water_and_Jug_Problem {

	// ver 1.0 StackOverflowError
	// public boolean canMeasureWater(int x, int y, int z) {
	// Set<String> result = new HashSet<String>();
	// return backtracking(x, y, 0, 0, z, result);
	// }
	//
	// public boolean backtracking(int x_cap, int y_cap, int x, int y, int z,
	// Set<String> history) {
	// if (x == z || y == z || (x + y == z))
	// return true;
	//
	// history.add(String.format("%d %d", x, y));
	//
	// // supply -> x
	// if (x != x_cap && !history.contains(String.format("%d %d", x_cap, y))
	// && backtracking(x_cap, y_cap, x_cap, y, z, history))
	// return true;
	// // supply -> y
	// if (y != y_cap && !history.contains(String.format("%d %d", x, y_cap))
	// && backtracking(x_cap, y_cap, x, y_cap, z, history))
	// return true;
	// // y -> x
	// if (y != 0
	// && x != x_cap
	// && !history.contains(String.format("%d %d", x_cap - x > y ? x
	// + y : x_cap, x_cap - x > y ? 0 : y - (x_cap - x)))
	// && backtracking(x_cap, y_cap, x_cap - x > y ? x + y : x_cap,
	// x_cap - x > y ? 0 : y - (x_cap - x), z, history))
	// return true;
	// // x -> y
	// if (x != 0
	// && y != y_cap
	// && !history.contains(String.format("%d %d", y_cap - y > x ? 0
	// : x - (y_cap - y), y_cap - y > x ? x + y : y_cap))
	// && backtracking(x_cap, y_cap, y_cap - y > x ? 0 : x
	// - (y_cap - y), y_cap - y > x ? x + y : y_cap, z,
	// history))
	// return true;
	// // x -> empty
	// if (x != 0 && !history.contains(String.format("%d %d", 0, y))
	// && backtracking(x_cap, y_cap, 0, y, z, history))
	// return true;
	// // y -> empty
	// if (y != 0 && !history.contains(String.format("%d %d", x, 0))
	// && backtracking(x_cap, y_cap, x, 0, z, history))
	// return true;
	//
	// return false;
	// }

	public boolean canMeasureWater(int x, int y, int z) {
		if (z == 0 || z == x || z == y || z == x + y)
			return true;

		Set<Integer> history = new HashSet<>();
		history.add(x);
		history.add(y);

		if (x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		Queue<Integer> queue = new LinkedList<>();
		int remain = y - x;
		queue.add(y - x);
		while (remain > x && x != 0) {
			remain -= x;
			queue.add(remain);
			history.add(remain);
		}

		while (queue.size() > 0) {
			int cur = queue.poll();
			if (history.add(cur)) {
				if (cur == z || cur + x == z || cur + y == z)
					return true;

				if (cur < x) {
					queue.add(y - (x - cur));
				}

				if (cur < y) {
					int tmp = cur;
					while (tmp + x < y) {
						tmp += x;
						queue.add(tmp);
					}
					queue.add(x - (y - tmp));
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _365_Water_and_Jug_Problem().canMeasureWater(
				0, 2, 1));
	}
}
