package examples.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(i -> i + 2)
                .thenApply(i -> i * 2)
                .thenAcceptAsync(System.out :: println)
                .thenRunAsync(() -> System.out.println("I was run from AsyncRun"));
    }
}
