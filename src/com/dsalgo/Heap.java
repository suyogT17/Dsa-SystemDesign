package com.dsalgo;

import java.util.Arrays;

public class Heap {

    int heapSize = 0;
    public static void main(String[] args) throws Exception {

        int A[]= new int[]{2,3,5,6,1,2,3,4};
        Heap heap = new Heap();
        heap.heapSize = A.length;
        heap.buildHeap(A);
        System.out.println("After Building Heap : "+ Arrays.toString(A));

        //heap.heapSort(A);
        //System.out.println("After Heap Sort : "+Arrays.toString(A));

        heap.increamentKey(A, 20, 2);
        System.out.println("After incrementing value Heap : "+ Arrays.toString(A));

        heap.decrementKey(A, 0, 3);
        System.out.println("After decrementing value Heap : "+ Arrays.toString(A));

        heap.heapSort(A);
        System.out.println("After Heap Sort : "+Arrays.toString(A));
    }

    void buildHeap(int[] A){
        for(int i = heapSize/2;i>=0;i--){
            maxHeapify(A, i, heapSize);
        }
    }


    void maxHeapify(int[] A, int i, int size){
        int largest = i; // 3
        int L = 2*i + 1; // 7
        int R = 2*i + 2; // 8

        if(L < size && A[L] > A[largest])
            largest = L; // 7

        if(R < size && A[R] > A[largest])
            largest = R;

        if(largest != i){
            swap(A, i, largest);
            maxHeapify(A, largest, size);
        }
    }

    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] =  temp;
    }

    int extractMax(int A[]) throws Exception {
        if(heapSize < 0) throw new Exception("Heap is empty");
        int max = A[0];
        A[0] = A[heapSize-1];
        heapSize = heapSize - 1;
        maxHeapify(A, 0, heapSize);
        return max;
    }

    void increamentKey(int A[], int key, int i) throws Exception {
        if(heapSize < 0) throw new Exception("Heap is Empty");
        if(A[i] > key) throw new Exception("Illegal Operation");
        A[i] = key;
        while(i > 0 && A[i] > A[i/2]) { //if i is not root and i is greater than its parent
            swap(A, i, i / 2);
            i = i / 2;
        }
    }

    void decrementKey(int A[], int key, int i) throws Exception{
        if(heapSize < 0) throw new Exception("Heap if Empty");
        if(A[i] < key) throw new Exception("Illegal Operation");
        A[i] = key;
        maxHeapify(A, i, heapSize);
    }

    void heapSort(int A[]){
        for(int i=heapSize-1;i>0;i--){
            swap(A, i, 0);
            maxHeapify(A, 0, i);
        }
    }
}
