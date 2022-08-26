package com.dsalgo.queue;

import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
 */
public class ReverseFirstKElements {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        reverseQueue(q, q.size());
        reverseQueue(q, q.size() - k);
        return q;
    }

    void reverseQueue(Queue<Integer> q, int k) {
        if (k == 0) {
            return;
        }
        int val = q.poll();
        reverseQueue(q, --k);
        q.offer(val);
    }
}
