package practice4.task4;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Pool that block when it has not any items or it full
 */
public class BlockingObjectPool {

    private int capacity = 1;
    private final BlockingQueue<Object> pool = new ArrayBlockingQueue<>(capacity);

    /**
     * Creates filled pool of passed size
     *
     * @param size of pool
     */
    public BlockingObjectPool(int size) {
        if (size > 0) capacity = size;
        else if (size < 1) throw new NoSuchElementException();
    }

    /**
     * Gets object from pool or blocks if pool is empty
     *
     * @return object from pool
     */
    public Object get() {
        while (pool.size() == 0) {
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
        try {
            obj = pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Puts object to pool or blocks if pool is full
     *
     * @param object to be taken back to pool
     */
    public void take(Object object) {
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

