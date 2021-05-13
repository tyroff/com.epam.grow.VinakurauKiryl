package practice4.task5_Compare.entity;

import practice4.task5_Compare.Main;
import practice4.task5_Compare.util.MyQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Implements the Runnable class, and in the run method finds the bus schedule by its number.
 *
 * @author Kiryl_Vinakurau
 */
public class ConsumerConcurrent extends Thread {

    private final BlockingQueue<Integer> blockingQueue;
    private Integer integer;

    public ConsumerConcurrent(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                integer = blockingQueue.take();
                int count = ++Main.countOperation;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
