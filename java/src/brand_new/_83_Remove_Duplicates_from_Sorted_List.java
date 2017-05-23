package brand_new;

public class _83_Remove_Duplicates_from_Sorted_List {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
