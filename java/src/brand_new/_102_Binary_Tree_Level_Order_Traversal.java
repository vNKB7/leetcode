package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _102_Binary_Tree_Level_Order_Traversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		
		List<TreeNode> layer = new ArrayList<>();
		layer.add(root);
		
		while(layer.size() > 0){
			List<TreeNode> new_layer = new ArrayList<>();
			List<Integer> layer_result = new ArrayList<>();
			
			for(TreeNode tn : layer){
				layer_result.add(tn.val);
				if(tn.left != null)
					new_layer.add(tn.left);
				if(tn.right != null)
					new_layer.add(tn.right);
			}
			
			result.add(layer_result);
			layer = new_layer;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
