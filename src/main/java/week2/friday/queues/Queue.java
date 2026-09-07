package week2.friday.queues;

import week2.friday.list.ArrayList;

/**
 * Making a Queue data structure.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> Generic used for the queue
 * @version 1.0
 */
public class Queue<T> implements iQueue<T> {
    private ArrayList<T> queueEx;

    /**
     * The constructor for the queue.
     */
    public Queue(){
        queueEx = new ArrayList<>();
    }

    @Override
    public void enQueue(T element) {
        queueEx.addLast(element);
    }

    @Override
    public T deQueue() {
        return queueEx.removeFirst();
    }

    @Override
    public T peek() {
        return queueEx.getFirst();
    }

    @Override
    public int size() {
        return queueEx.size();
    }

    @Override
    public boolean isEmpty() {
        return queueEx.isEmpty();
    }

    @Override
    public String toString(){
        return queueEx.toString();
    }
}
