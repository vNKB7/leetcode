package brand_new;

import java.util.PriorityQueue;

public class _295_Find_Median_from_Data_Stream {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
	}
}

class MedianFinder {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
		return o2 - o1;
	});
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
		return o1 - o2;
	});
	int count = 0;

	/** initialize your data structure here. */
	public MedianFinder() {
	}

	public void addNum(int num) {
		if (count % 2 == 0) {
			if (maxHeap.size() > 0 && maxHeap.peek() < num) {
				minHeap.add(num);
				maxHeap.add(minHeap.poll());
			} else {
				maxHeap.add(num);
			}
		} else {
			if (minHeap.size() > 0 && minHeap.peek() > num) {
				maxHeap.add(num);
				minHeap.add(maxHeap.poll());
			} else {
				minHeap.add(num);
			}
		}
		count++;
	}

	public double findMedian() {
		if (count == 0) {
			return 0;
		}

		if (count % 2 == 0) {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}
}
