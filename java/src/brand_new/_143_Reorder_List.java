package brand_new;

public class _143_Reorder_List {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode pesudoHead = new ListNode(0);
		ListNode cur = slow.next;
		slow.next = null;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = pesudoHead.next;
			pesudoHead.next = cur;
			cur = tmp;
		}
		
		ListNode p = head;
		ListNode q = pesudoHead.next;
		
		while(q != null){
			ListNode tmp = q.next;
			q.next = p.next;
			p.next = q;
			p = q.next;
			q = tmp;
		}
	}
	
	public static void main(String[] args){
		new _143_Reorder_List().reorderList(ListNode.getList(new int[]{1,2,3}));
	}
}
