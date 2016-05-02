package leetcode;

public class SwapNodesinPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head == null){
			return null;
		}else if(head.next == null){
			return head;
		}
		
		ListNode rt = head.next;
		
		ListNode curNode = new ListNode(-1);
		curNode.next = head;
		
		while(curNode.next != null && curNode.next.next != null){
			ListNode n1 = curNode.next;
			ListNode n2 = n1.next;
			
			curNode.next = n2;
			n1.next = n2.next;
			n2.next = n1;
			
			curNode = n1;
		}
		
		return rt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
