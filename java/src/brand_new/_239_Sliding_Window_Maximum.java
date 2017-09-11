package brand_new;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class _239_Sliding_Window_Maximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k) {
			return new int[0];
		}

		int[] result = new int[nums.length - k + 1];
		MaxQueue<Integer> mq = new MaxQueue<>();
		for (int i = 0; i < k; i++) {
			mq.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			result[i - k] = mq.max();
			mq.poll();
			mq.add(nums[i]);
		}
		
		result[result.length-1] = mq.max();

		return result;
	}

	class MaxQueue<T extends Comparable<T>> {
		LinkedList<T> queue = new LinkedList<>();
		LinkedList<T> maxQueue = new LinkedList<>();

		public void add(T obj) {
			queue.addLast(obj);
			ListIterator<T> it = maxQueue.listIterator(maxQueue.size());
			int remove = 0;
			while (it.hasPrevious()) {
				if (it.previous().compareTo(obj) < 0) {
					remove++;
				} else {
					break;
				}
			}

			for (int i = 0; i < remove; i++) {
				maxQueue.removeLast();
			}

			maxQueue.addLast(obj);
		}

		public T poll() {
			if (queue.size() == 0) {
				return null;
			}

			T obj = queue.pollFirst();
			if (obj.compareTo(maxQueue.getFirst()) == 0) {
				maxQueue.pollFirst();
			}

			return obj;
		}

		public T peek() {
			return queue.getFirst();
		}

		public T max() {
			if (maxQueue.size() == 0) {
				return null;
			} else {
				return maxQueue.getFirst();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new _239_Sliding_Window_Maximum()
				.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
	}
}
