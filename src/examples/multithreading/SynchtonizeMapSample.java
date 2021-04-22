package examples.multithreading;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SynchtonizeMapSample {

    public static void main(String[] args) {
        Map<Integer, Integer> resource = Collections.synchronizedMap(new HashMap<>());
        List<Thread> pool = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            final int val = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100));
 //                   synchronized (resource) {
                        resource.put(val, val + ((int) (Math.random() * 10)));
 //                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            pool.add(t);
            t.setName("Thread #" + val);
        }

        long startTime = System.currentTimeMillis();

        pool.forEach(e -> e.start());
        pool.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        System.out.println(System.currentTimeMillis() - startTime);

        System.out.println("Size is: " + resource.size());

    }
}
