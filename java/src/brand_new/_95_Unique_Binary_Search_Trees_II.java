package brand_new;

import java.util.ArrayList;
import java.util.List;
/*
 * 还可以用动态规划优化
 * 下面这个写法，部分树节点是共用的
 */
public class _95_Unique_Binary_Search_Trees_II {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		if(n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}
	
	public List<TreeNode> generateTrees(int min, int max){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(min > max){
			result.add(null);
			return result;
		}
		
		if(min == max){
			result.add(new TreeNode(min));
			return result;
		}
		
		for(int i = min; i <= max; i++){
			List<TreeNode> left = generateTrees(min, i - 1);
			List<TreeNode> right = generateTrees(i+1, max);
			
			for(int j = 0; j < left.size(); j++){
				for(int k = 0; k < right.size(); k++){
					TreeNode node = new TreeNode(i);
					node.left = left.get(j);// deep copy !!!
					node.right = right.get(k);
					result.add(node);
				}
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		List<TreeNode> result = new _95_Unique_Binary_Search_Trees_II().generateTrees(3);
		System.out.println(result.size());
	}

}
