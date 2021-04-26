package practice4.task1_DasExperiment;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ThreadSafeMap thread = new ThreadSafeMap();
        new Thread(() -> thread.workWithMap(map)).start();
        new Thread(() -> thread.workWithMap(map)).start();
    }
}
