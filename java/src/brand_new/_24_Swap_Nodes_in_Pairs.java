package brand_new;

public class _24_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		ListNode pesudoHead = new ListNode(0);
		pesudoHead.next = head;
		ListNode cur = pesudoHead;
		while(cur.next != null && cur.next.next != null){
			ListNode first = cur.next, second = cur.next.next;
			cur.next = second;
			first.next = second.next;
			second.next = first;
			cur = first;
		}
		return pesudoHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
