package com.systemdesign.machinecoding.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerNormal {

    private LinkedList<Integer> queue;
    private int capacity;

    public ProducerConsumerNormal(int capacity){
        this.queue = new LinkedList<>();
        this.capacity =  capacity;
    }

    public void produce(){
        int value = 0;
        while(true) {
            synchronized (this.getClass()) {
                try {
                    if (queue.size() == capacity) {
                        System.out.println("queue is full producer waiting");
                        wait();
                    }
                    System.out.println("Producer has produced " + value);
                    queue.addFirst(value++);
                    //notify();
                    Thread.sleep(1000);

                }catch (InterruptedException exception){
                    System.out.println("error occurred in producer");
                }
            }
        }
    }

    public void consume(){
        while(true){
            synchronized (this.getClass()){
                try {
                    if(queue.isEmpty()) {
                        System.out.println("queue is empty consumer waiting");
                        wait();
                    }
                    int el =  queue.pollLast();
                    System.out.println("consumer consumed "+el);
                    //notify();
                    Thread.sleep(1000);

                }catch (InterruptedException exception){
                    System.out.println("error occurred in consumer");
                }
            }
        }
    }
}
