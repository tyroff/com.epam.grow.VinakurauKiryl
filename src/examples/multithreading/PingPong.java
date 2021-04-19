package examples.multithreading;

public class PingPong {

    private String last = "PONG\n";

    private synchronized void action(String message) {
        while (true) { // вызыв метода обёртки, в котором wait оборачивается в блок try-catch. Для уменьшения объёма кода.
            if (last.equals(message)) {
                wait(this);
            } else {
                System.out.print(message);
                last = message;
                sleep(500);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        new Thread(() -> pingPong.action("ping ")).start();
        new Thread(() -> pingPong.action("PONG\n")).start();
    }

    private static void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
