package examples.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockSample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Map<String, Integer> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        service.submit(() -> {
           long spamp = lock.writeLock();
            try {
                TimeUnit.SECONDS.sleep(1);
                map.put("Vitebsk", 600_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(spamp);
            }
        });

        Runnable taskRead = () -> {
            long stamp;
            if ((stamp = lock.tryOptimisticRead()) != 0L) {
                Integer population = map.get("Vitebsk");
                if (lock.validate(stamp)) {
                    System.out.println(population + " from Optimistic reading.");
                }
            }

            stamp = lock.readLock();
            try {
                System.out.println(map.get("Vi tebsk") + " from Read Lock.");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }

        };

        service.submit(taskRead);
        service.submit(taskRead);

    }
}
