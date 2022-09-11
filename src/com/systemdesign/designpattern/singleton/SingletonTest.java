package com.systemdesign.designpattern.singleton;

//Approach using enums remaining
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        System.out.println("Instance 1: " + System.identityHashCode(instance1));
        Singleton instance2 = Singleton.getInstance();
        System.out.println("Instance 2: " + System.identityHashCode(instance2));
    }
}

class SingletonThreadTest {
    public static void main(String[] args) {
        Runnable thread1 = new InstanceCreatorThreadTest();
        Runnable thread2 = new InstanceCreatorThreadTest();

        new Thread(thread1).start();
        new Thread(thread2).start();
    }
}

class InstanceCreatorThreadTest implements Runnable {
    public void run() {
        Singleton instance1 = Singleton.getInstance();
        System.out.println("Instance 1: " + System.identityHashCode(instance1));
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton(){}

    static Singleton getInstance(){
        synchronized (Singleton.class) {
            if(instance == null)
                instance = new Singleton();
            return instance;
        }
    }
}

