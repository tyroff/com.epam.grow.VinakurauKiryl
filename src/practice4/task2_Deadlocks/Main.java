package practice4.task2_Deadlocks;

public class Main {

    public static void main(String[] args) {
        ReadWriteArrayList rwArrayList = new ReadWriteArrayList();
        new Thread(() -> rwArrayList.add()).start();
        new Thread(() -> rwArrayList.calculateSquareRoot()).start();
        new Thread(() -> rwArrayList.countSum()).start();
    }
}
