package brand_new;

public class _19_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int offest = 0;
		ListNode fast = head, slow = head;
		
		while(fast.next != null){
			if(offest == n){
				slow = slow.next;
			}else{
				offest ++;
			}
			fast = fast.next;
		}
		if(offest == n){
			slow.next = slow.next.next;
		}else if(offest == n-1){
			head = head.next;
		}
		
		return head;
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
