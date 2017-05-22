package brand_new;

public class _61_Rotate_List {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null)
			return null;
		
		ListNode pesudoHead = new ListNode(0);
		pesudoHead.next = head;
		ListNode cur = pesudoHead;
		int count = 0;
		while (cur.next != null) {
			count++;
			cur = cur.next;
		}
		
		if(k == 0)
			return head;
		
		ListNode p = pesudoHead;
		for(int i = 0; i < count - k%count; i ++)
			p = p.next;
		
		cur.next = pesudoHead.next;
		pesudoHead.next = p.next;
		p.next = null;
		
		return pesudoHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 
}
