package examples.multithreading.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {

    public static final Integer FIBONACCI_INDEX = 30;

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(FIBONACCI_INDEX);
        long startTime = System.currentTimeMillis();
        Integer fibonacciNumber = (Integer) forkJoinPool.invoke(task);

        System.out.println("fibonacciNumber = " + fibonacciNumber);
        System.out.println(System.currentTimeMillis() - startTime + " sec.");
        System.out.println("Count tasks: " + FibonacciTask.getTaskCounter());
    }
}
