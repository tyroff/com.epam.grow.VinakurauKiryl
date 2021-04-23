package practice4.task3_MessageBus.entity;

import practice4.task3_MessageBus.util.MyQueue;

import java.util.concurrent.TimeUnit;

/**
 * Implements the Runnable class, and in the run method finds the bus schedule by its number.
 *
 * @author Kiryl_Vinakurau
 */
public class Consumer implements Runnable {

    private final MyQueue queue;
    private int desiredBusNumber;
    private BusMessage message;

    public Consumer(MyQueue queue, int desiredBusNumber) {
        this.queue = queue;
        if (desiredBusNumber > 0) this.desiredBusNumber = desiredBusNumber;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(700);
                message = (BusMessage) queue.take();
                if (desiredBusNumber == message.getBusNumber()) {
                    System.out.println("\nThis is my bus :) -> " + message.toString() + " " + Thread.currentThread().getName() + "\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
