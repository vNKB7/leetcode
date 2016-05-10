package leetcode;

import leetcode.SwapNodesinPairs.ListNode;

public class ReverseNodesinkGroup {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)
			return null;
		
		if(k <= 1)
			return head;
		
		
		ListNode rt = null;
		
		ListNode headNode = new ListNode(-1);
		headNode.next = head;
		
		ListNode lastNode = null;
		
		while(true){
			
			//headNode = headNode;//headNode本身还是上一轮的headNode，因为在上一轮中翻转过了
			lastNode = headNode;
			
			for(int i = 0; i < k; i++){
				if(lastNode.next == null){
					if(rt == null)
						return head;//!!!!
					else
						return rt;
				}else{
					lastNode = lastNode.next;
				}
			}		
			
			ListNode tail = headNode.next;
			
			for(int i = 0; i < k - 1; i++){
				ListNode next = tail.next;
				tail.next = next.next;
				next.next = headNode.next;
				headNode.next = next;
			}
			
			if(rt == null)
				rt = headNode.next;
			
			headNode = tail;
		}

	}

	public static void main(String[] args) {
		ReverseNodesinkGroup instance = new ReverseNodesinkGroup();
		ListNode fakeHead = instance.new ListNode(-1);
		for(int i = 10; i > 0; i--){
			ListNode head = instance.new ListNode(i);
			head.next = fakeHead.next;
			fakeHead.next = head;
		}
		
		ListNode cur = fakeHead.next;
		ListNode rt = instance.reverseKGroup(cur, 3);
		
		
		while(rt != null){
			System.out.print(rt.val+" ");
			rt = rt.next;
		}
		System.out.println();
	}
	

}
