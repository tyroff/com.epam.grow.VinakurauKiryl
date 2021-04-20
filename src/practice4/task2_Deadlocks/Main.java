package practice4.task2_Deadlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    private static int numberOperation = 1;
    private static List<Integer> list = new ArrayList<>();
    //private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        WriterToCollection writerToCollection = new WriterToCollection();
        SumCollection sumCollection = new SumCollection();
        SquareRootCollection squareRootCollection = new SquareRootCollection();

        new Thread(() -> {
            synchronized (list) {
                writerToCollection.writeRandomNumber(list);
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (list) {
                sumCollection.countSum(list);
            }
        }).start();
        new Thread(() -> {
            synchronized (list) {
                squareRootCollection.calculateSquareRoot(list);
            }
        }).start();
    }
}
