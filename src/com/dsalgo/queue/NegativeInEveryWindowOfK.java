package com.dsalgo.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
 */
class NegativeInEveryWindowOfK {
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Queue<Integer> queue = new LinkedList();
        long[] output = new long[N - K + 1];
        int i = 0;
        for (; i < K - 1; i++) {
            if (A[i] < 0) {
                queue.offer(i);
            }
        }
        for (; i < N; i++) {
            if (A[i] < 0) queue.offer(i);
            if (queue.isEmpty() || queue.peek() < i - K + 1) {
                if (!queue.isEmpty()) {
                    queue.poll();
                    if (queue.isEmpty()) output[i - K + 1] = 0;
                    else output[i - K + 1] = A[queue.peek()];
                }
            } else {
                output[i - K + 1] = A[queue.peek()];
            }
        }
        return output;
    }
}