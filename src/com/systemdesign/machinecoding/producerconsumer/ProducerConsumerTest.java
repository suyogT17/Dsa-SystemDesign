package com.systemdesign.machinecoding.producerconsumer;

public class ProducerConsumerTest {
    public static void main(String[] args) throws Exception {
        ProducerConsumerNormal producerConsumer =  new ProducerConsumerNormal(3);
        Thread producer =  new Thread(() -> producerConsumer.produce());
        Thread consumer = new Thread(() -> producerConsumer.consume());

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
