package leetcode;

public class MergeTwoSortedLists {

	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }

	public class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	ListNode head = new ListNode(-1);
	    	ListNode cur = head;
	    	
	    	while(l1 != null && l2 != null){
	    		if(l1.val <= l2.val){
	    			cur.next = new ListNode(l1.val);
	    			cur = cur.next;
	    			l1 = l1.next;
	    		}else{
	    			cur.next = new ListNode(l2.val);
	    			cur = cur.next;
	    			l2 = l2.next;
	    		}
	    	}
	    	
	    	while(l1 != null){
	    		cur.next = new ListNode(l1.val);
	    		cur = cur.next;
	    		l1 = l1.next;
	    	}
	    	
	    	while(l2 != null){
	    		cur.next = new ListNode(l2.val);
	    		cur = cur.next;
	    		l2 = l2.next;
	    	}
	    	
	        return head.next;
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
