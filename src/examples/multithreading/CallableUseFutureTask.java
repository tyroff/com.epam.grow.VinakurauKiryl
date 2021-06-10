package examples.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableUseFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable task = () -> {
            return "Hello, World";
        };

        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
