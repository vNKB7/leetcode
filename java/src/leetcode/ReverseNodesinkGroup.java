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
			
			if(rt == null)
				rt = lastNode;
			
			ListNode lastPoint = lastNode;
			ListNode lastNext = lastNode.next;
			
			
			ListNode tail = headNode.next;
			
			for(int i = 0; i < k -1; i++){
				ListNode next = tail.next;
				tail.next = next.next;
				next.next = headNode.next;
				headNode.next = next;
			}
			
			
			
			
			
			
//			while(headNode.next != lastPoint){
//				ListNode p = headNode;
//				
//				for(; p.next != lastPoint; p = p.next){
//					
//				}
//				
//				lastPoint.next = p;
//				lastPoint = lastPoint.next;
//			}
			
			ListNode tmp = headNode.next;//原本headNode所指向的下一个，这一轮翻转之后的最后一个
			headNode.next = lastNode;
			headNode = tmp;
			
			lastPoint.next = lastNext;
		}

	}

	public static void main(String[] args) {
		

	}
	

}
