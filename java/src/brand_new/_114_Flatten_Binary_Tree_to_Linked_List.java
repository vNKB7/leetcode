package brand_new;

import java.util.Stack;

public class _114_Flatten_Binary_Tree_to_Linked_List {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		while (cur != null || stack.size() > 0) {
			while (cur.left != null) {
				if (cur.right != null)
					stack.push(cur.right);
				cur.right = cur.left;
				cur.left = null;
				cur = cur.right;
			}

			if (cur.right != null)
				stack.push(cur.right);

			if (stack.size() > 0) {
				TreeNode right = stack.pop();
				cur.right = right;
				cur = cur.right;
			} else
				break;
		}
	}

	public static void main(String[] args) {

	}
}
