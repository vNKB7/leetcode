package brand_new;

public class _222_Count_Complete_Tree_Nodes {
	int buttom = 0;

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = leftHeight(root.left);
		int right = rightHeight(root.right);
		if (left == right) {
			return (int) Math.pow(2, left + 1) - 1;
		} else {
			if (root.left == null) {
				return 1;
			} else if (root.right == null) {
				return 2;
			} else {
				if (getButtom(root.left))
					getButtom(root.right);
			}
			return (int) Math.pow(2, left) - 1 + buttom;
		}
	}

	public boolean getButtom(TreeNode root) {
		int left = leftHeight(root.left);
		int right = rightHeight(root.right);
		if (left == right)
			buttom += Math.pow(2, left - 1);
		else {
			if (root.left == null) {
				return true;
			} else if (root.right == null) {
				buttom++;
			} else {
				if (getButtom(root.left))
					getButtom(root.right);
			}
		}
		return false;
	}

	public int leftHeight(TreeNode root) {
		int count = 0;
		while (root != null) {
			root = root.left;
			count++;
		}
		return count;
	}

	public int rightHeight(TreeNode root) {
		int count = 0;
		while (root != null) {
			root = root.right;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {

	}

}
