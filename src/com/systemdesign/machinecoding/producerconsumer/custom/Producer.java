package com.systemdesign.machinecoding.producerconsumer.custom;

public class Producer implements Runnable {

    DataQueue dataQueue;

    public Producer(DataQueue dataQueue){
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        produce();
    }

    private void produce(){
        int val = 0;
        while(true){
            try {
                if (dataQueue.isFull()) {
                    dataQueue.waitOnFull();
                }
            }catch (InterruptedException exception){
                System.out.println("producer is waiting as queue is full");
            }
            System.out.println("producer produced value "+val);
            dataQueue.add(val++);
            dataQueue.notifyAllOnEmpty();
            try { Thread.sleep(1000);}
            catch(InterruptedException e){}
        }
    }
}
