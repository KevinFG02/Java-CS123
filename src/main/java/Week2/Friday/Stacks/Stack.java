package Week2.Friday.Stacks;

import Week2.Friday.List.ArrayList;

public class Stack<T> implements IStack<T> {
    private ArrayList<T> list;

    public Stack(){
        list = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        list.addLast(element);
    }

    @Override
    public T pop() {
        return list.removeLast();
    }

    @Override
    public T peek() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
