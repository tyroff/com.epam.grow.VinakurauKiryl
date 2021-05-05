package examples.multithreading;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class DaemonSample {
    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
/*                while (!isInterrupted()) {
                    try {
                        sleep(1_000);
                        System.out.println("Thread is work!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        interrupt(); // т.к. это ошибка sleep(), по этой причине необходимо в catch завершить поток.
                        Правильная констркуция описана ниже, в try помещён цикл с методом isInterrupt().
                        //break; - в данной конструкции так тоже можно завершить поток.
                    }
                }*/
                try {
                    while (!isInterrupted()) {
                        sleep(1_000);
                        System.out.println("Thread is work!");
                    }
                } catch (InterruptedException e) {
                    System.out.println("----------Thread interrupted-----------");
                }
            }
        };

        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1_000);
                        System.out.println("I am daemon! HA-HA-HA :)");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        try {
            int count = 0;
            while (!currentThread().isInterrupted()) {
                if (count == 3) currentThread().interrupt();
                sleep(1_000);
                System.out.println("main");
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }
    }
}
