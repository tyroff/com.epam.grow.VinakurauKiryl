package practice4.task2_Deadlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class is used for: is infinitely writing random number to the collection; is printing sum of the numbers in
 * the collection; is printing square root of sum of squares of all numbers in
 *
 * @author Kiryl_Vinakurau
 */
public class ReadWriteArrayList {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    private List<Integer> list = new ArrayList<>();
    private int sum = 0;
    private int sumSquareRoot = 0;
    private final int END_ADD = 10;

    /**
     * Adds an element to the {@code ArrayList} collection and displays the name of the stream and the added element
     * to the console.
     */
    public void add() {
        while (true) {
            for (int i = 0; i < END_ADD; i++) {
                writeLock.lock();
            try {
                    int j = (int) (Math.random() * 100);
                    list.add(j);
                    sleep(200);
                    System.out.println(Thread.currentThread().getName() + " -> Add = " + j);
                } finally {
                    writeLock.unlock();
                }
            }
            sleep(1000);
        }
    }

    /**
     * Calculates the sum of the {@code ArrayList} collection and displays the name of the stream and the resulting
     * value of the sum to the console.
     */
    public void countSum() {
        while (true) {
            readLock.lock();
            try {
                list.forEach(i -> sum += i);
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " -> Sum = " + sum);
                sum = 0;
            } finally {
                readLock.unlock();
            }
        }
    }

    /**
     * Printing square root of sum of squares of all numbers in the collection
     */
    public void calculateSquareRoot() {
        while (true) {
            readLock.lock();
            try {
                sleep(1000);
                list.forEach(integer -> sumSquareRoot += Math.sqrt(integer));
                System.out.println(Thread.currentThread().getName() + " -> Sqrt = " + Math.sqrt(sumSquareRoot));
                sumSquareRoot = 0;
            } finally {
                readLock.unlock();
            }
        }
    }

    /**
     * To handle exceptions in one place to reduce the amount of code.
     *
     * @param millisec number of milliseconds.
     */
    private void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
