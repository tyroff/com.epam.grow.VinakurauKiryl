package practice4.task2_Deadlocks;

import java.util.List;

/**
 * Counts the sum of the collection.
 *
 * @author Kiryl_Vinakurau
 */
public class SumCollection {

    private final int NUMBER_OPERATION = 2;
    private int sum = 0;

    /**
     * Counts the sum of the collection.
     *
     * @param list collection of random numbers.
     */
    public void countSum(List<Integer> list) {
        while (true) {
            list.forEach(integer -> sum += integer);
            System.out.println(Thread.currentThread().getName() + " -> Sum = " + sum);
            sum = 0;
            sleep(800);
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

    /**
     * To handle exceptions in one place to reduce the amount of code.
     *
     * @param object an object to wait.
     */
    private void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
