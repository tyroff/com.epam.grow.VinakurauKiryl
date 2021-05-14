package practice4.task5_Compare.entity;

import practice4.task5_Compare.Main;
import practice4.task5_Compare.util.MyQueue;

/**
 * Implements the Runnable class, and in the run method creates bus numbers and their schedules.
 *
 * @author Kiryl_Vinakurau
 */
public final class ProducerClassic extends Thread {

    private final MyQueue<Integer> queue;
    private Integer integer;

    public ProducerClassic(MyQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                integer = (int) (Math.random() * 10 + 1);
                queue.put(integer);
                int count = ++Main.countOperation;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
