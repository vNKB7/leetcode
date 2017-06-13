package brand_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _399_Evaluate_Division {
	public double[] calcEquation(String[][] equations, double[] values,
			String[][] queries) {
		Map<String, List<Edge>> adj = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			if (!adj.containsKey(equations[i][0])) {
				adj.put(equations[i][0], new ArrayList<Edge>());
			}
			adj.get(equations[i][0]).add(
					new Edge(equations[i][0], equations[i][1], values[i]));

			if (!adj.containsKey(equations[i][1])) {
				adj.put(equations[i][1], new ArrayList<Edge>());
			}
			adj.get(equations[i][1]).add(
					new Edge(equations[i][1], equations[i][0],
							values[i] == 0 ? -1 : 1 / values[i]));
		}

		double[] result = new double[queries.length];
		Arrays.fill(result, -1);
		for (int i = 0; i < result.length; i++) {
			if (!adj.containsKey(queries[i][0])) {
				result[i] = -1;
				continue;
			}

			Set<String> visited = new HashSet<>();
			List<String> list = new ArrayList<>();
			list.add(queries[i][0]);
			List<Double> div = new ArrayList<>();
			div.add(1.0);
			visited.add(queries[i][0]);
			boolean flag = true;
			while (list.size() > 0 && flag) {
				List<String> new_list = new ArrayList<>();
				List<Double> new_div = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).equals(queries[i][1])) {
						result[i] = div.get(j);
						flag = false;
						break;
					}

					if (adj.containsKey(list.get(j))) {
						for (Edge e : adj.get(list.get(j))) {
							if (e.val != -1 && !visited.contains(e.dest)) {
								new_list.add(e.dest);
								new_div.add(div.get(j) * e.val);
								visited.add(e.dest);
							}
						}
					}
				}
				list = new_list;
				div = new_div;
			}

		}
		return result;
	}

	class Edge {
		String src;
		String dest;
		double val;

		public Edge(String src, String dest, double val) {
			this.src = src;
			this.dest = dest;
			this.val = val;
		}

		@Override
		public boolean equals(Object otherObject) {
			if (this == otherObject)
				return true;

			if (otherObject == null)
				return false;

			if (getClass() != otherObject.getClass())
				return false;

			Edge other = (Edge) otherObject;

			return src == other.src && dest == other.dest;
		}

		@Override
		public int hashCode() {
			return 7 * Objects.hashCode(src) + 13 * Objects.hashCode(dest);
		}
	}

	public static void main(String[] args) {
		String[][] equations = { { "a", "b" }, { "e", "f" }, { "b", "e" } };
		double[] values = { 3.4, 1.4, 2.3 };
		String[][] queries = { { "a", "f" }, { "f", "f" },
				{ "e", "e" }, { "c", "c" }, { "a", "c" }, { "f", "e" } };
		System.out.println(Arrays.toString(new _399_Evaluate_Division()
				.calcEquation(equations, values, queries)));
	}

}
