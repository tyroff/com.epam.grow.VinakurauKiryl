package practice4.task2_Deadlocks;

import java.util.List;

/**
 * Square root of sum of squares of all numbers in the collection
 *
 * @author Kiryl_Vinakurau
 */
public class SquareRootCollection {

    private final int NUMBER_OPERATION = 3;
    private int sumSquareRoot = 0;

    /**
     * Printing square root of sum of squares of all numbers in the collection
     *
     * @param list collection of random numbers.
     */
    public void calculateSquareRoot(List<Integer> list) {
        while (true) {
            list.forEach(integer -> sumSquareRoot += Math.sqrt(integer));
            System.out.println(Thread.currentThread().getName() + " -> Sum sqrt = " + Math.sqrt(sumSquareRoot));
            wait(this);
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
