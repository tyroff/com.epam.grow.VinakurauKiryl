package examples.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorSample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable task1 = () -> {
            System.out.println("Hello from task1 " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from task2 " + Thread.currentThread().getName());
        };

        executor.submit(task1);
        executor.submit(task2);

        try {
            System.out.println("Trying to shutdown");
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("Task was interrupted");
        } finally {
/*            if(!executor.isTerminated()) {
                System.out.println("Start tasks cancellation");
            }*/
            executor.shutdownNow();
            System.out.println("Pool is dead!");
        }
    }
}
