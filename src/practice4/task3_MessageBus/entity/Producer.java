package practice4.task3_MessageBus.entity;

import practice4.task3_MessageBus.util.MyQueue;

import java.util.concurrent.TimeUnit;

/**
 * Implements the Runnable class, and in the run method creates bus numbers and their schedules.
 *
 * @author Kiryl_Vinakurau
 */
public final class Producer implements Runnable {

    private final MyQueue queue;
    private int maxBusNumber;
    private BusMessage message;

    public Producer(MyQueue queue, int maxBusNumber) {
        this.queue = queue;
        if (maxBusNumber > 0) this.maxBusNumber = maxBusNumber;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(700);
                message = new BusMessage(maxBusNumber);
                System.out.println(message.toString() + " " + Thread.currentThread().getName());
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
