package com.systemdesign.machinecoding.producerconsumer.custom;

public class Consumer implements Runnable {

    DataQueue dataQueue;

    public Consumer(DataQueue dataQueue){
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        consume();
    }

    private void consume(){
        while(true){
            try {
                if (dataQueue.isEmpty()) {
                    dataQueue.waitOnEmpty();
                }
            }catch (InterruptedException exception){
                System.out.println("consumer is waiting as queue is empty");
            }
            int val = dataQueue.remove();
            System.out.println("consumer consumed data "+val);
            dataQueue.notifyAllOnFull();
            try { Thread.sleep(1000);}
            catch(InterruptedException e){}
        }
    }
}
