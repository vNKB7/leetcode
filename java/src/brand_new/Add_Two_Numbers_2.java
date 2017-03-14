package brand_new;

public class Add_Two_Numbers_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		int c = 0;
		while (l1 != null && l2 != null) {
			cur.next = new ListNode((l1.val + l2.val + c) % 10);
			cur = cur.next;
			c = (l1.val + l2.val + c) / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode l = l1 != null ? l1 : l2;
		while (l != null) {
			cur.next = new ListNode((l.val + c) % 10);
			cur = cur.next;
			c = (l.val + c) / 10;
			l = l.next;
		}

		if (c == 1) {
			cur.next = new ListNode(1);
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[] { 4 });
		ListNode head2 = ListNode.getList(new int[] { 5 });
		new Add_Two_Numbers_2().addTwoNumbers(head, head2).display();
	}

}
