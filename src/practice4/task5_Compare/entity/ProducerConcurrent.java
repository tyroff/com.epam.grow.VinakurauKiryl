package practice4.task5_Compare.entity;

import practice4.task5_Compare.Main;
import practice4.task5_Compare.util.MyQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Implements the Runnable class, and in the run method creates bus numbers and their schedules.
 *
 * @author Kiryl_Vinakurau
 */
public final class ProducerConcurrent extends Thread {

    private final BlockingQueue<Integer> blockingQueue;
    private Integer integer;

    public ProducerConcurrent(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                integer = (int) (Math.random() * 10 + 1);
                blockingQueue.put(integer);
                int count = ++Main.countOperation;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
