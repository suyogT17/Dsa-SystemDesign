package com.dsalgo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
 */
public class StackUsingTwoQueue {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a) {
        q1.add(a);
    }

    int pop() {
        int ans = -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        if (!q1.isEmpty()) ans = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return ans;
    }
}
