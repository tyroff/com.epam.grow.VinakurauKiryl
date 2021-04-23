package practice4.task3_MessageBus;

import practice4.task3_MessageBus.entity.Consumer;
import practice4.task3_MessageBus.entity.Producer;
import practice4.task3_MessageBus.util.MyBlockingQueue;
import practice4.task3_MessageBus.util.MyQueue;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyBlockingQueue(10);
        new Thread(new Producer(queue, 5)).start();
        new Thread(new Producer(queue, 6)).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Consumer(queue, 2)).start();
        new Thread(new Consumer(queue, 2)).start();
    }
}
