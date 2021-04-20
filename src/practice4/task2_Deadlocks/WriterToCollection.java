package practice4.task2_Deadlocks;

import java.util.ArrayList;
import java.util.List;

/**
 * A stream class that writes values to a collection.
 *
 * @author Kiryl_Vinakurau
 */
public class WriterToCollection {

    private final int NUMBER_OPERATION = 1;

    /**
     * writing random number to the collection
     *
     * @param list collection for writing random numbers.
     */
    public void writeRandomNumber(List<Integer> list) {
        while (true) {
            int i = (int) (Math.random() * 100);
            list.add(i);
            sleep(800);
            System.out.println(Thread.currentThread().getName() + " -> Add number = " + i);
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
