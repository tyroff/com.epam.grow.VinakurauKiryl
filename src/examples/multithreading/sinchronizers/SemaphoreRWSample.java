package examples.multithreading.sinchronizers;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreRWSample {

    public static void main(String[] args) {
        Semaphore writingSemaphore = new Semaphore(1);
        Semaphore readingSemaphore = new Semaphore(10);
        List<Integer> resource = new ArrayList<>();
        List<Thread> pool = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int value = i;
            Thread writer = new Thread(() -> {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100));
                    writingSemaphore.acquire(); //разрешение/получение доступа
                    resource.add(value);
                    System.out.println(Thread.currentThread().getName() + " add -> " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writingSemaphore.release(); //возвращаем.отпускаем доступ
                }
            });
            writer.setName("Writer #" + value);
            pool.add(writer);
        }

        for (int i = 0; i < 100; i++) {
            int value = i;
            Thread reader = new Thread(() -> {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100));
                    readingSemaphore.acquire(); //разрешение/получение доступа
                    System.out.println(resource.size());
                    System.out.println(Thread.currentThread().getName() + " read -> " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readingSemaphore.release(); //возвращаем.отпускаем доступ
                }
            });
            reader.setName("Reader #" + value);
            pool.add(reader);
        }

        pool.forEach(Thread :: start);

        pool.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        System.out.println("Final result size: " + resource.size());
    }
}
