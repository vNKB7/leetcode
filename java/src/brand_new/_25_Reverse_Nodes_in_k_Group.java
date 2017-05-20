package brand_new;

public class _25_Reverse_Nodes_in_k_Group {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;

		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
			if (count == k)
				break;
		}
		
		if(count != k)
			return head;
		
		ListNode pesudoHead = new ListNode(0);
		ListNode p = head, q;
		while(p != cur){
			q = p.next;
			p.next = pesudoHead.next;
			pesudoHead.next = p;
			p = q;
		}
		
		head.next = reverseKGroup(p, k);
		
		return pesudoHead.next;
	}

	public static void main(String[] args) {
		_25_Reverse_Nodes_in_k_Group instance = new _25_Reverse_Nodes_in_k_Group();
		ListNode fakeHead = instance.new ListNode(-1);
		for (int i = 10; i > 0; i--) {
			ListNode head = instance.new ListNode(i);
			head.next = fakeHead.next;
			fakeHead.next = head;
		}

		ListNode cur = fakeHead.next;
		ListNode rt = instance.reverseKGroup(cur, 4);

		while (rt != null) {
			System.out.print(rt.val + " ");
			rt = rt.next;
		}
		System.out.println();
	}

}
