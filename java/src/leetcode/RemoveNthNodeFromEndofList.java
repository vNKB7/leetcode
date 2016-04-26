package leetcode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode q = null;
		ListNode r = head;

		if (head == null) {
			return null;
		}

		while (r != null) {
			if (n == 0) {
				q = head;
			}else if(n < 0){
				q = q.next;
			}
			
			n--;
			r = r.next;
		}

		if (n > 0) {
			return null;
		} else if (n == 0) {
			head = head.next;
			return head;
		} else {
			if(q.next == null)
				return null;
			else{
				q.next = q.next.next;
				return head;
			}
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		//head.next = new ListNode(2);

		ListNode a = RemoveNthNodeFromEndofList.removeNthFromEnd(head, 1);
		while (a != null) {
			System.out.println(a.val);
			a = a.next;
		}
	}
	
	
	
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode newhead = new ListNode(-1);  //防止头被删除
//        newhead.next = head;
//        ListNode point1 = newhead;
//        ListNode point2 = newhead;
//        for(;point1 != null;point1 = point1.next,n--)  //point1 控制长度
//        {
//            if(n < 0)
//                point2 = point2.next;   //point2延迟启动
//        } 
//        point2.next = point2.next.next;
//        return newhead.next;
//    }

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}