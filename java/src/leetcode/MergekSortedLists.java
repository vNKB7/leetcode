package leetcode;

import leetcode.MergeTwoSortedLists.ListNode;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}else if(lists.length == 1){
			return lists[0];
		}else
			return merge(lists);
	}

	ListNode merge(ListNode[] lists) {
		if (lists.length > 2) {
			int leftPart = (int) (lists.length / 2);
			int rightPart = lists.length - leftPart;

			ListNode[] left = new ListNode[leftPart];
			ListNode[] right = new ListNode[rightPart];

			for (int i = 0; i < leftPart; i++) {
				left[i] = lists[i];
			}

			for (int i = 0; i < rightPart; i++) {
				right[i] = lists[i + leftPart];
			}

			
			//merge two lists
			ListNode l1 = merge(left);
			ListNode l2 = merge(right);

			return mergeTwoLists(l1, l2);
			
		}else if(lists.length == 2){
			return mergeTwoLists(lists[0], lists[1]);
		}else{
			return lists[0];
		}
	}
	
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

//https://leetcode.com/discuss/98532/simple-java-nlog-k-solution-with-explanation
//https://leetcode.com/discuss/96427/my-3ms-java-solution-with-explanation-similar-the-merge-sort
