package week2.friday.queues;

public interface iQueue<T> {
    void enQueue(T element);
    T deQueue();
    T peek();
    int size();
    boolean isEmpty();
}
