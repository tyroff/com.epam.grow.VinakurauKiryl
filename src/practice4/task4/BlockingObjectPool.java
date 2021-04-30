package practice4.task4;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Pool that block when it has not any items or it full
 */
public class BlockingObjectPool {

    private int capacity = 1;
    private final Queue<Object> pool = new LinkedList<>();

    /**
     * Creates filled pool of passed size
     *
     * @param size of pool
     */
    public BlockingObjectPool(int size) {
        if (size > 0) capacity = size;
        else throw new IllegalArgumentException();
    }

    /**
     * Gets object from pool or blocks if pool is empty
     *
     * @return object from pool
     */
    public synchronized Object get() {
        if (pool.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (pool.size() == capacity) {
            notifyAll();
        }
        Object obj = new Object();
        obj = pool.peek();
        return obj;
    }

    /**
     * Puts object to pool or blocks if pool is full
     *
     * @param object to be taken back to pool
     */
    public synchronized void take(Object object) {
        if (pool.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (pool.size() == 0) {
            notifyAll();
        }
        pool.add(object);
    }
}

