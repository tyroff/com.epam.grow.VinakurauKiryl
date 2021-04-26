package examples.multithreading.forkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciTask extends RecursiveTask {

    private Integer fibonacciIndex;
    private static AtomicInteger taskCounter = new AtomicInteger(0);

    public FibonacciTask(Integer fibonacciIndex) {
        this.fibonacciIndex = fibonacciIndex;
    }

    public static Integer getTaskCounter() {
        return taskCounter.get();
    }

    @Override
    protected Integer compute() {
        if (fibonacciIndex ==0) return 0;
        if (fibonacciIndex == 1) return 1;

        final FibonacciTask task1 = new FibonacciTask(fibonacciIndex-1);
        task1.fork(); //производит асинхронный запуск задачи
        taskCounter.getAndIncrement();
        Integer result1 = (Integer) task1.join();

        final FibonacciTask task2 = new FibonacciTask(fibonacciIndex-2);
        Integer result2 = task2.compute();
        taskCounter.getAndIncrement();

        return result1 + result2;
    }
}
