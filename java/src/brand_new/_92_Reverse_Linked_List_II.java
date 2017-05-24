package brand_new;

public class _92_Reverse_Linked_List_II {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode pesudoHead = new ListNode(0);
		pesudoHead.next = head;

		ListNode start = pesudoHead;
		for (int i = 1; i < m; i++)
			start = start.next;

		ListNode newHead = new ListNode(0);
		newHead.next = start.next;
		ListNode tail = newHead.next;
		ListNode end = start.next;
		for (int i = 0; i < n - m + 1; i++) {
			ListNode tmp = end.next;
			end.next = newHead.next;
			newHead.next = end;
			end = tmp;
		}

		start.next = newHead.next;
		tail.next = end;

		return pesudoHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
