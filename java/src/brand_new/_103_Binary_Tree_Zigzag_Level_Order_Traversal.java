package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		List<TreeNode> layer = new ArrayList<>();
		layer.add(root);

		boolean inverted = false;
		while (layer.size() > 0) {
			List<TreeNode> new_layer = new ArrayList<>();
			List<Integer> layer_result = new ArrayList<>();

			for (int i = layer.size() - 1; i >= 0; i--) {
				TreeNode tn = layer.get(i);
				layer_result.add(tn.val);
				if (inverted) {
					if (tn.right != null)
						new_layer.add(tn.right);
					if (tn.left != null)
						new_layer.add(tn.left);
				} else {
					if (tn.left != null)
						new_layer.add(tn.left);
					if (tn.right != null)
						new_layer.add(tn.right);
				}
			}

			inverted = !inverted;

			result.add(layer_result);
			layer = new_layer;
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
