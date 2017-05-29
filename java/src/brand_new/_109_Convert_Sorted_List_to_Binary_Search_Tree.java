package brand_new;

public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
	ListNode cur;
	public TreeNode sortedListToBST(ListNode head) {
		cur = head;
		ListNode p = head;
		int count = 0;
		while(p != null){
			count ++;
			p = p.next;
		}
		return sortedListToBST(0, count);
	}
	
	public TreeNode sortedListToBST(int i, int j) {
		if(i >= j)
			return null;
		else if(j - i == 1){
			TreeNode node = new TreeNode(cur.val);
			cur = cur.next;
			return node;
		}else{
			int mid = (i + j) / 2;
			TreeNode node = new TreeNode(0);
			node.left = sortedListToBST(i, mid);
			node.val = cur.val;
			cur = cur.next;
			node.right = sortedListToBST(mid+1, j);
			return node;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
