package brand_new;

public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

	public void connect(TreeLinkNode root) {
		TreeLinkNode first = root;
		while (first != null) {
			TreeLinkNode cur = first;
			while (cur != null) {
				TreeLinkNode next = cur.next;
				while (next != null) {
					if (next.left != null) {
						next = next.left;
						break;
					} else if (next.right != null) {
						next = next.right;
						break;
					} else {
						next = next.next;
					}
				}
				if (cur.left != null) {
					if (cur.right != null) {
						cur.left.next = cur.right;
					} else {
						cur.left.next = next;
					}
				}
				if (cur.right != null) {
					cur.right.next = next;
				}
				cur = cur.next;
			}

			while (first != null) {
				if (first.left != null) {
					first = first.left;
					break;
				} else if (first.right != null) {
					first = first.right;
					break;
				}
				first = first.next;
			}
		}
	}

	public static void main(String[] args) {

	}

}
