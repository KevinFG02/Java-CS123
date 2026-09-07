package week2.friday.stacks;

public interface IStack<T> {
    void push(T element);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
