package brand_new;

public class _307_Range_Sum_Query_Mutable {

	public static void main(String[] args) {
		NumArray na = new NumArray(new int[]{1,3,5});
		System.out.println(na.sumRange(0,2));
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));
		
	}

}

class NumArray {
	
	class SegmentTreeNode{
		int val;
		int start;
		int end;
		SegmentTreeNode left, right;
		
		public SegmentTreeNode(int start, int end){
			this.start = start;
			this.end = end;
		}
	} 

	SegmentTreeNode root = null;
	
    public NumArray(int[] nums) {
    	root = building(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
    	update(root, i, val);
    }
    
    public int sumRange(int i, int j) {
    	return sumRange(root, i, j);
    }
    
    public SegmentTreeNode building(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}
    	
    	SegmentTreeNode node = new SegmentTreeNode(start, end);
    	
    	if(start == end){
    		node.val = nums[start];
    	}else{
    		int mid = start + (end - start) / 2;
    		node.left = building(nums, start, mid);
    		node.right = building(nums, mid+1, end);
    		node.val = node.left.val + node.right.val;
    	}
    	
    	return node;
    }
    
    public void update(SegmentTreeNode node, int i, int val){
    	if(node.start == node.end){
    		node.val = val;
    		return;
    	}
   
    	int mid = node.start + (node.end - node.start) / 2;
    	if(i <= mid){
    		update(node.left, i, val);
    	}else{
    		update(node.right, i, val);
    	}
    	
    	node.val = node.left.val + node.right.val;
    }
    
    public int sumRange(SegmentTreeNode node, int i, int j){
    	if(node.start == i && node.end == j)
    		return node.val;
    	
    	int mid = node.start + (node.end - node.start) / 2;
    	if(j <= mid){
    		return sumRange(node.left, i, j);
    	}else if(i > mid){
    		return sumRange(node.right, i, j);
    	}else{
    		return sumRange(node.left, i, mid) + sumRange(node.right, mid+1, j);
    	}
    }
}