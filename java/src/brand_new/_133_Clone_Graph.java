package brand_new;

import java.util.HashMap;
import java.util.Map;

public class _133_Clone_Graph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
		if (node == null)
			return null;
		UndirectedGraphNode dest = new UndirectedGraphNode(node.label);
		visited.put(node, dest);
		cloneGraph(node, dest, visited);
		return dest;
	}

	public void cloneGraph(UndirectedGraphNode src, UndirectedGraphNode dest,
			Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
		for (UndirectedGraphNode s : src.neighbors) {
			if (!visited.containsKey(s)) {
				UndirectedGraphNode nextNode = new UndirectedGraphNode(s.label);
				visited.put(s, nextNode);
				cloneGraph(s, nextNode, visited);
			}
			dest.neighbors.add(visited.get(s));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
