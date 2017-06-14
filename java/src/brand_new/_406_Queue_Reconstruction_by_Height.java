package brand_new;

import java.util.Arrays;

public class _406_Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
		int[][] result = new int[people.length][2];
		int size = 0;
		for (int i = 0; i < people.length; i++) {
			for (int j = 0; j < people.length; j++)
				if (people[j][1] == i) {
					insert(result, people[j], size);
					size++;
				}
		}

		return result;
	}

	public void insert(int[][] list, int[] node, int size) {
		if (size == 0) {
			list[0] = node;
		} else {
			int val = node[0];
			int k = node[1];

			for (int i = 0; i < size; i++) {
				if (list[i][0] >= val) {
					k--;
					if (k < 0) {
						for(int j = size; j > i; j--){
							list[j] = list[j-1];
						}
						list[i] = node;
						return;
					}
				}
			}
		}
		list[size] = node;
	}

	public static void main(String[] args) {
		System.out.println(Arrays
				.deepToString(new _406_Queue_Reconstruction_by_Height()
						.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 },
								{ 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } })));
	}

}
