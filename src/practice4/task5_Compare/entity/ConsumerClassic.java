package practice4.task5_Compare.entity;

import practice4.task5_Compare.Main;
import practice4.task5_Compare.util.MyQueue;

import java.util.concurrent.TimeUnit;

/**
 * Implements the Runnable class, and in the run method finds the bus schedule by its number.
 *
 * @author Kiryl_Vinakurau
 */
public class ConsumerClassic extends Thread {

    private final MyQueue<Integer> queue;
    private Integer integer;

    public ConsumerClassic(MyQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                integer = queue.take();
                int count = ++Main.countOperation;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
