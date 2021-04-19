package practice4.task1_DasExperiment;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * This class is needed to work with threads with a common Map.
 */
public final class ThreadSafeMap {

    private static int key = 1;
    private static int seeKey = 1;
    private static int sumValues = 0;
    private static Class clazz = ThreadSafeMap.class;


    public synchronized void workWithMap(Map map) {
        while (true) {
            if (key == seeKey) {
                addInMap(map);
                wait(this);
            } else {
                sumValuesMap(map);
                notifyAll();
            }
        }
    }

    /**
     * Adds elements to the map by key starting from 1 with a randomly generated value from 0 to 9.
     *
     * @param map map to which elements are added by key and value.
     */
    private void addInMap(Map<Integer, Integer> map) {
        int value = (int) (Math.random() * 10);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " -> Add: key = " + key + " value = " + map.get(key));
        key++;
        sleep(800);
    }

    /**
     * In the map finds the value of the elements by key from 1 and higher and sums their value.
     *
     * @param map values are taken from this card and summed up in the {@code sumValues} parameter.
     */
    private void sumValuesMap(Map<Integer, Integer> map) {
        if (map.containsKey(seeKey)) {
            sumValues += map.get(seeKey);
            System.out.println(Thread.currentThread().getName() + " -> Sum = " + sumValues);
            seeKey++;
            sleep(800);
        } else {
            System.out.println("Exception: Map " + map + " haven't key = " + seeKey);
            throw new NoSuchElementException();
        }
    }

    /**
     * To handle exceptions in one place to reduce the amount of code.
     *
     * @param millisec number of milliseconds.
     */
    private void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * To handle exceptions in one place to reduce the amount of code.
     *
     * @param object an object to wait.
     */
    private static void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
