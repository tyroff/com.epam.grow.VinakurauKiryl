package examples.multithreading;

public class StarvationSample {

    private static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Worker(), "Thread1");
        Thread thread2 = new Thread(new Worker(), "Thread2");
        Thread thread3 = new Thread(new Worker(), "Thread3");
        Thread thread4 = new Thread(new Worker(), "Thread4");

        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(2000);
        isRunning = false;
    }

    private static class Worker implements Runnable {

        private Integer counter = 0;

        @Override
        public void run() {
            while (isRunning) {
                counter++;
            }
            System.out.println(Thread.currentThread().getName() + " -> count = " + counter);
        }
    }
}
