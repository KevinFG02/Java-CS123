package Week2.Friday.Queues;

public interface iQueue<T> {
    void enQueue(T element);
    T deQueue();
    T peek();
    int size();
    boolean isEmpty();
}
