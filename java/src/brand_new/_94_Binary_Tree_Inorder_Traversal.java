package brand_new;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_Binary_Tree_Inorder_Traversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		List<Integer> result = new ArrayList<Integer>();

		while (cur != null || stack.size() > 0) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			if (stack.size() > 0) {
				cur = stack.pop();
				result.add(cur.val);
				cur = cur.right;
			}
		}
		

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
