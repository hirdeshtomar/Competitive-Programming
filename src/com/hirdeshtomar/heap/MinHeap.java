package com.hirdeshtomar.heap;

import java.util.Arrays;

public class MinHeap {

	private int CAPACITY = 20;
	private int size = 0;
	int[] arr = new int[CAPACITY];
	
	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	private int getLeftChildIndex(int index) {
		return 2*index + 1;
	}
	
	private int getRightChildIndex(int index) {
		return 2*index + 2;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;	
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	
	private void ensureExtraCapacity() {
		if(size == CAPACITY) {
			arr = Arrays.copyOf(arr, CAPACITY * 2);
			CAPACITY = CAPACITY*2;
		}
	}
	
	public int size() {
		return size;
	}
	public void add(int item) {
		ensureExtraCapacity();
		arr[size] = item;
		size = size +1;
		heapifyUp();
	}
	
	public int poll() {
		
		if(size == 0)
			return -1;
		
		int value = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapifyDown();
		
		return value;
	}
	
	public int peek() {
		if(size == 0)
			return -1;
		return arr[0];
	}
	
	private void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	private void heapifyUp() {
		
		int index = size-1;
		
		while(hasParent(index)) {
			int parentIndex = getParentIndex(index);
			if(arr[parentIndex] > arr[index]) {
				swap(index, parentIndex);
				index = parentIndex;
			}
			else
				break;
		}
		
	}
	
	private void heapifyDown() {
		
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallChildIndex =getLeftChildIndex(index);
			if(hasRightChild(index) && arr[getRightChildIndex(index)] < arr[getLeftChildIndex(index)])
				smallChildIndex = getRightChildIndex(index);
			if(arr[index] > arr[smallChildIndex]) {
				swap(index, smallChildIndex);
				index = smallChildIndex;
			}
			else
				break;	
		}	
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinHeap minHeap = new MinHeap();
		
		minHeap.add(4);
		minHeap.add(8);
		minHeap.add(5);
		minHeap.add(2);
		minHeap.add(9);
		
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		
		
		//System.out.println(minHeap.poll());
		
	}*/

}
