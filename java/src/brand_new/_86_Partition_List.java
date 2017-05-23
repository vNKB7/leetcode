package brand_new;

public class _86_Partition_List {

	public ListNode partition(ListNode head, int x) {
		ListNode less = new ListNode(0);
		ListNode greater = new ListNode(0);
		ListNode p1 = less, p2 = greater;

		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				head = head.next;
				p1 = p1.next;
			} else {
				p2.next = head;
				head = head.next;
				p2 = p2.next;
			}
		}
		p1.next = greater.next;
		p2.next = null;
		return less.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
