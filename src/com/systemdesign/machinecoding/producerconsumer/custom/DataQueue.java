package com.systemdesign.machinecoding.producerconsumer.custom;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private Queue<Integer> queue =  new LinkedList<>();
    private final Object QUEUE_FULL = new Object();
    private final Object QUEUE_EMPTY = new Object();
    private int capacity;

    public DataQueue(int capacity){
        this.capacity = capacity;
    }

    void waitOnFull() throws InterruptedException {
        synchronized (QUEUE_FULL){
            QUEUE_FULL.wait();
        }
    }

    void waitOnEmpty() throws InterruptedException {
        synchronized (QUEUE_EMPTY){
            QUEUE_EMPTY.wait();
        }
    }

    void notifyAllOnEmpty(){
        synchronized (QUEUE_EMPTY){
            QUEUE_EMPTY.notifyAll();
        }
    }

    void notifyAllOnFull(){
        synchronized (QUEUE_FULL){
            QUEUE_FULL.notifyAll();
        }
    }

    void add(int val){
        synchronized (queue){
            queue.offer(val);
        }
    }

    int remove(){
        synchronized (queue){
            return queue.poll();
        }
    }

    boolean isEmpty(){
        synchronized (queue) {
            return queue.isEmpty();
        }
    }

    boolean isFull(){
        synchronized(queue){
            return queue.size() == capacity ;
        }
    }
}
