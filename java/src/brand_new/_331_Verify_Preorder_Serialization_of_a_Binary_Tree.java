package brand_new;

public class _331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	public boolean isValidSerialization(String preorder) {
		String[] node = preorder.split(",");

		int depth = 0, index = 0;
		for (; index < node.length; index++) {
			if (!node[index].equals("#")) {
				depth++;
			} else {
				depth--;
			}
			if (depth < 0)
				break;
		}
		return index == node.length - 1;
	}

	public static void main(String[] args) {
		System.out
				.println(new _331_Verify_Preorder_Serialization_of_a_Binary_Tree()
						.isValidSerialization("9,#,92,#,#"));
	}

}
