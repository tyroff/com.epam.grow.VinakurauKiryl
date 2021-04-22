package examples.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicSample {
    public AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        AtomicSample lockSample = new AtomicSample();

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 10_000_000; i++) {
               lockSample.counter.getAndIncrement();
           }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                lockSample.counter.getAndDecrement();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("sum = " + lockSample.counter);
    }
}
