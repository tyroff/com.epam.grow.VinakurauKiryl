package practice4.task5_Compare.util;

/**
 * A collection for storing items before processing.
 * @author Kiryl_Vinakurau
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {

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
    void put(E element) throws InterruptedException;

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     *
     * @return the head of this queue
     * @throws InterruptedException if interrupted while waiting
     */
    E take() throws InterruptedException;

    /**
     * Removes the first element from the array.
     */
    void remove();
}
