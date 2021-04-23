package practice4.task3_MessageBus.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Bounded blocking queue backed by an array. It is a "bounded buffer" in which a fixed size array contains elements
 * inserted by producers and retrieved by consumers. Once created, the capacity cannot be changed. Attempts to put an
 * item on a full queue will block the operation; attempts to take an element from an empty queue will similarly block.
 *
 * @param <E> the type of object added to the LinkedList
 * @author Kiryl_Vinakurau
 */
public final class MyBlockingQueue<E> implements MyQueue<E>, java.io.Serializable {

    private List queue = new LinkedList();
    private int limit = 1;

    public MyBlockingQueue(int limit) {
        this.limit = --limit;
    }

    /**
     * Inserts the specified element into this queue, waiting if necessary
     * for space to become available.
     *
     * @param element the element to add
     * @throws InterruptedException if interrupted while waiting
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this queue
     */
    public synchronized void put(E element) throws InterruptedException {
        if (queue.size() == limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(element);
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     *
     * @return the head of this queue
     * @throws InterruptedException if interrupted while waiting
     */
    public synchronized E take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        E element = (E) this.queue.remove(0);
        return element;
    }

    /**
     * Removes the first item from the list.
     */
    @Override
    public void remove(){
        queue.remove(0);
    }
}
