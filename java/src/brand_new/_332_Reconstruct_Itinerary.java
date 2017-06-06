package brand_new;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _332_Reconstruct_Itinerary {

	public List<String> findItinerary(String[][] tickets) {
		List<String> result = new ArrayList<>();

		Map<String, List<String>> adj = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			if (!adj.containsKey(tickets[i][0]))
				adj.put(tickets[i][0], new ArrayList<String>());
			adj.get(tickets[i][0]).add(tickets[i][1]);
		}

		DFS(result, adj, "JFK", tickets.length);
		Collections.sort(result);
		List<String> rt = new ArrayList<>();
		String str = result.get(0);
		for (int i = 0; i < str.length(); i += 3) {
			rt.add(str.substring(i, i + 3));
		}
		return rt;
	}

	public void DFS(List<String> result, Map<String, List<String>> adj,
			String curPath, int count) {
		if (count == 0) {
			result.add(curPath);
			return;
		}

		String from = curPath.substring(curPath.length() - 3);
		if (adj.get(from) == null)
			return;
		List<String> tos = new ArrayList<>(adj.get(from));
		for (int i = 0; i < tos.size(); i++) {
			String to = tos.get(i);
			adj.get(from).remove(i);
			DFS(result, adj, curPath + to, count - 1);
			adj.get(from).add(i, to);
		}
	}

	public static void main(String[] args) {
		String[][] array = { { "CNS", "TIA" }, { "CNS", "EZE" },
				{ "ADL", "TIA" }, { "EZE", "AUA" }, { "BNE", "AUA" },
				{ "ANU", "JFK" }, { "ANU", "CNS" }, { "CNS", "JFK" },
				{ "AUA", "JFK" }, { "ANU", "AUA" }, { "AUA", "AXA" },
				{ "JFK", "EZE" }, { "ADL", "TIA" }, { "ANU", "BNE" },
				{ "AUA", "JFK" }, { "TIA", "ADL" }, { "AXA", "EZE" },
				{ "CNS", "AXA" }, { "AUA", "TIA" }, { "ADL", "ANU" },
				{ "JFK", "ANU" }, { "CNS", "AXA" }, { "BNE", "EZE" },
				{ "EZE", "TIA" }, { "AUA", "CNS" }, { "BNE", "TIA" },
				{ "EZE", "ADL" }, { "EZE", "ADL" }, { "TIA", "ANU" },
				{ "AUA", "CNS" }, { "TIA", "AXA" }, { "TIA", "EZE" },
				{ "AXA", "ANU" }, { "ANU", "TIA" }, { "ANU", "CNS" },
				{ "ADL", "CNS" }, { "EZE", "AUA" }, { "CNS", "AUA" },
				{ "TIA", "ADL" }, { "JFK", "AUA" }, { "EZE", "JFK" },
				{ "AUA", "TIA" }, { "TIA", "EZE" }, { "JFK", "ANU" },
				{ "AXA", "CNS" }, { "TIA", "SYD" }, { "JFK", "ANU" },
				{ "AXA", "JFK" }, { "CNS", "AUA" }, { "JFK", "BNE" },
				{ "AUA", "CNS" }, { "JFK", "EZE" }, { "EZE", "AUA" },
				{ "TIA", "BNE" } };
		System.out.println(new _332_Reconstruct_Itinerary()
				.findItinerary(array));
	}

}
