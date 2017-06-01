package brand_new;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_Preorder_Traversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || stack.size() > 0) {
			while (cur != null) {
				result.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}

			if (stack.size() > 0) {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return result;
	}
}
