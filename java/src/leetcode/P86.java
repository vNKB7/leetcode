public class P86 {

	public ListNode partition(ListNode head, int x) {
		if(head == null)
			return null;
		
		ListNode lessHead = null, lessPoint = null, greatHead = null, greatPoint = null, point = head;
		while(point != null){
			if(point.val < x){
				if(lessHead == null){
					lessHead = point;
					lessPoint = point;
				}else{
					lessPoint.next = point;
					lessPoint = lessPoint.next;
				}
			}else{
				if(greatHead == null){
					greatHead = point;
					greatPoint = point;
				}else{
					greatPoint.next = point;
					greatPoint = greatPoint.next;
				}
			}
			point = point.next;
		}
		
		if(lessHead == null)
			return greatHead;
		if(greatHead == null)
			return lessHead;
		
		lessPoint.next = greatHead;
		greatPoint.next = null;
		return lessHead;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		a.next = new ListNode(1);
		ListNode l = new P86().partition(a, 2);
		while(l != null){
			System.out.println(l.val);
			l = l.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
