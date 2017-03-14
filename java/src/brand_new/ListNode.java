package brand_new;

import java.util.List;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	public static ListNode getList(List<Integer> array){
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int i : array){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		head = head.next;
		return head;
	}
	
	public static ListNode getList(int[] array){
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int i : array){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		head = head.next;
		return head;
	}
	
	public void display(){
		System.out.print(val);
		ListNode cur = next;
		while(cur != null){
			System.out.print("->"+cur.val);
			cur = cur.next;
		}
		System.out.println();
	}
}

