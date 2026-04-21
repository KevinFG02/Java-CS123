package Week2.Friday.Queues;

import Week2.Friday.List.ArrayList;

public class Queue<T> implements iQueue<T> {
    private ArrayList<T> queueEx;

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
