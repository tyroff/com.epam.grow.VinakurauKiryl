package examples.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AlphabetSample {

    public static void main(String[] args) {

        final BlockingQueue<Character> bq = new ArrayBlockingQueue<>(3);

        Runnable producer = () -> {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                try {
                    bq.put(ch);
                    System.out.println(ch + " was produced");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
          char ch = 'O';
          do {
              try {
                  ch = bq.take();
                  System.out.println(ch + " was taken");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          } while (ch != 'Z');
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
