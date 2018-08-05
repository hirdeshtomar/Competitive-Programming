package com.hirdeshtomar.heap;

public class MedianRunningStream {

	MinHeap minHeap = new MinHeap();
	MaxHeap maxHeap = new MaxHeap();

	private int findMedianInStream(int a) {

		if (maxHeap.size() == 0) {
			maxHeap.add(a);
			return a;
		}

		if (maxHeap.size() > minHeap.size()) {

			if (a > minHeap.peek()) {

				minHeap.add(a);
			} else {
				minHeap.add(maxHeap.poll());
				maxHeap.add(a);
			}
			return (minHeap.peek() + maxHeap.peek()) / 2;

		} else {
			if (a > minHeap.peek()) {
				maxHeap.add(minHeap.poll());
				minHeap.add(a);
			} else {
				maxHeap.add(a);
			}
			return maxHeap.peek();
		}

	}

	public static void main(String[] args) {

		int[] stream = { 5, 15, 1, 3 };
		MedianRunningStream sol = new MedianRunningStream();

		for (int i = 0; i < stream.length; i++) {
			System.out.println("New Stream Value: " + stream[i]);
			System.out.println("Median: " + sol.findMedianInStream(stream[i]));
		}

	}

}
