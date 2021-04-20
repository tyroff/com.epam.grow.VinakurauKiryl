package examples.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {
    public Integer counter = 0;
    public Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        LockSample lockSample = new LockSample();

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               lockSample.lock.lock();
               try {
                   lockSample.counter++;
                   System.out.println(Thread.currentThread().getName() + " -> " + lockSample.counter);
               } finally {
                   lockSample.lock.unlock();
               }
           }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockSample.lock.lock();
                try {
                    lockSample.counter--;
                    System.out.println(Thread.currentThread().getName() + " -> " + lockSample.counter);
                } finally {
                    lockSample.lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("sum = " + lockSample.counter);
    }
}
