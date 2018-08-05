package com.hirdeshtomar.heap;

import java.util.Arrays;

public class MaxHeap {

	private int CAPACITY = 20;
	int size = 0;
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
		arr[size++] = item;
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
			if(arr[parentIndex] < arr[index]) {
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
			int largeChildIndex =getLeftChildIndex(index);
			if(hasRightChild(index) && arr[getRightChildIndex(index)] > arr[getLeftChildIndex(index)])
				largeChildIndex = getRightChildIndex(index);
			if(arr[index] < arr[largeChildIndex]) {
				swap(index, largeChildIndex);
				index = largeChildIndex;
			}
			else
				break;	
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		MaxHeap maxHeap = new MaxHeap();
		
		maxHeap.add(4);
		maxHeap.add(8);
		maxHeap.add(5);
		maxHeap.add(2);
		maxHeap.add(9);
		
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		*/
		
		//System.out.println(minHeap.poll());
		
	}

}
