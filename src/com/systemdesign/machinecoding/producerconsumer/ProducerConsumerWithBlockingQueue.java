package com.systemdesign.machinecoding.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithBlockingQueue {

    private BlockingQueue<Integer> queue;
    private int capacity;

    public ProducerConsumerWithBlockingQueue(int capacity){
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    public void produce(){
        int value = 0;
        while(true) {
            try {
                System.out.println("Producer has produced " + value);
                queue.put(value++);
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                System.out.println("error occurred in producer");
            }
        }
    }

    public void consume(){
        while(true){
            synchronized (this.getClass()){
                try {
                    int el =  queue.take();
                    System.out.println("consumer consumed "+el);
                    Thread.sleep(1000);

                }catch (InterruptedException exception){
                    System.out.println("error occurred in consumer");
                }
            }
        }
    }
}
