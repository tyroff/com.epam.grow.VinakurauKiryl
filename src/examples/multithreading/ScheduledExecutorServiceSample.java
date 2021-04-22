package examples.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceSample {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.schedule(() -> {
            System.out.println("Ping google.com");
        }, 1, TimeUnit.SECONDS);
    }
}
