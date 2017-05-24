package brand_new;

import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {
 
 	
	public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
        int pre = Integer.MIN_VALUE;
        boolean isfirst = true;
        
		while (cur != null || stack.size() > 0) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			if (stack.size() > 0) {
				cur = stack.pop();
				if(isfirst){
				    pre = cur.val;
				    isfirst = false;
				}else if(pre < cur.val)
		            pre = cur.val;
		        else
		            return false;
				cur = cur.right;
			}
		}
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
