package examples.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableSample {

    public static void main(String[] args) throws ExecutionException {
        //ExecutorService pool = Executors.newFixedThreadPool(100);
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Long>> results = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < 1_000_000; i++) {
            final int val = 1;
            Callable<Long> task = () -> {
                TimeUnit.MILLISECONDS.sleep(100);
                long result = val * val * val;
                return result;
            };
            Future<Long> result = pool.submit(task);
            results.add(result);
        }

        try {
            pool.shutdown();
            pool.awaitTermination(10, TimeUnit.SECONDS);

            for (Future<Long> result : results) {
                sum += result.get();
            }

            System.out.println("SUM = " + sum);
            System.out.println("=> " + ((ThreadPoolExecutor)pool).getLargestPoolSize());
        } catch (InterruptedException e) {
        } finally {
            pool.shutdownNow();
        }
    }
}
