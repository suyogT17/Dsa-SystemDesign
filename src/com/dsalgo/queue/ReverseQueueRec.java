package com.dsalgo.queue;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/queue-reversal/1
 */
class ReverseQueueRec{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.

        reverseQueue(q);
        return q;

    }


    void reverseQueue(Queue<Integer> q){
        //base condition
        if(q.isEmpty()){
            return;
        }
        int val =  q.poll();
        reverseQueue(q);
        q.offer(val);

    }

}