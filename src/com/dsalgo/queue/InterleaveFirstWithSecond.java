package com.dsalgo.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/interleave-the-first-half-of-the-queue-with-the-second-half_1169450
 * You have been given a queue of integers. You need to rearrange the elements of the queue by interleaving the elements of the first half of the queue with the second half.
 * Note :
 * The given queue will always be of even length.
 * For Example :
 * If N= 10
 * and Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * then the output will be
 *  Q = [10, 60, 20, 70, 30, 80, 40, 90, 50, 100]
 */
public class InterleaveFirstWithSecond {
    public static void interLeaveQueue(Queue<Integer> q) {
        // Write your code here.
        int n = q.size();
        Queue<Integer> temp = new LinkedList();
        for (int i = 0; i < n / 2; i++) {
            temp.offer(q.poll());
        }
        for (int i = 0; i < n / 2; i++) {
            q.offer(temp.poll());
            q.offer(q.poll());
        }
    }
}