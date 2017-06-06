package brand_new;

public class _328_Odd_Even_Linked_List {
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;

		ListNode oddHead = new ListNode(0);
		oddHead.next = head;
		ListNode evenHead = new ListNode(0);
		ListNode odd = head, even = evenHead;
		while (odd != null && odd.next != null) {
			ListNode tmp = odd.next;
			odd.next = odd.next.next;
			even.next = tmp;
			tmp.next = null;
			even = even.next;
			if (odd.next != null)
				odd = odd.next;
			else
				break;
		}
		odd.next = evenHead.next;
		return oddHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
