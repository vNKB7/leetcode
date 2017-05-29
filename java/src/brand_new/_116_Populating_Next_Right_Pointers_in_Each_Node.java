package brand_new;

public class _116_Populating_Next_Right_Pointers_in_Each_Node {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode first = root;
		while (first != null) {
			TreeLinkNode cur = first;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
					if (cur.next != null)
						cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			first = first.left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
