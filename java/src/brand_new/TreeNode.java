package brand_new;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode construct(int[] array) {
		int index = 0;
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(array[index++]);
		list.add(root);
		while (list.size() > 0) {
			List<TreeNode> new_list = new ArrayList<TreeNode>();
			for (TreeNode tn : list) {
				if (tn != null) {
					if(index >= array.length)
						break;
					if (array[index] == -1) {
						tn.left = null;
						new_list.add(null);
					} else {
						tn.left = new TreeNode(array[index]);
						new_list.add(tn.left);
					}
					index++;
					if(index >= array.length)
						break;
					if (array[index] == -1) {
						tn.right = null;
						new_list.add(null);
					} else {
						tn.right = new TreeNode(array[index]);
						new_list.add(tn.right);
					}
				}
			}
			list = new_list;
		}
		return root;
	}
	
}
