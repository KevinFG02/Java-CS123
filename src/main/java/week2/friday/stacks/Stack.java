package week2.friday.stacks;

import week2.friday.list.ArrayList;

/**
 * Making a Stack data structure.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> The generic used for the Stack data structure.
 * @version 1.0
 */
public class Stack<T> implements IStack<T> {
    private ArrayList<T> list;

    /**
     * A constuctor for the Stack data structure.
     */
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
