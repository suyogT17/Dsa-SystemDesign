package com.systemdesign.machinecoding.producerconsumer.custom;

public class ProducerConsumerTest2 {

    public static void main(String[] args) {
        DataQueue dataQueue =  new DataQueue(3);
        Thread producer = new Thread(new Producer(dataQueue));
        Thread consumer = new Thread(new Consumer(dataQueue));

        producer.start();
        consumer.start();
    }
}
