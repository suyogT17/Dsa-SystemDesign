package com.dsalgo.heaps;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
 * Given two binary max heaps as arrays, merge the given heaps to form a new max heap.
 *
 * Example 1:
 *
 * Input  :
 * n = 4 m = 3
 * a[] = {10, 5, 6, 2},
 * b[] = {12, 7, 9}
 * Output :
 * {12, 10, 9, 2, 5, 7, 6}
 */
class MergeTwoBinaryHeap {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int heap[] = new int[n + m];
        int size = 0;
        for (int num : a) {
            heap[size++] = num;
            //heapify(heap, 0, ++size);
        }
        for (int num : b) {
            heap[size++] = num;
            //heapify(heap, 0, ++size);
        }
        for (int i = (heap.length / 2) - 1; i >= 0; i--) {
            heapify(heap, i, size);
        }
        //System.out.println(Arrays.toString(heap));
        return heap;
    }


    void heapify(int heap[], int start, int end) {
        int left = start * 2 + 1;
        int right = start * 2 + 2;
        int largest = start;
        if (left < end && heap[left] > heap[largest]) largest = left;
        if (right < end && heap[right] > heap[largest]) largest = right;
        if (largest != start) {
            swap(heap, start, largest);
            heapify(heap, largest, end);
        }
    }

    void swap(int heap[], int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}